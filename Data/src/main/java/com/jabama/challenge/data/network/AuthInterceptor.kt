package com.jabama.challenge.data.network

import com.jabama.challenge.data.repository.token.TokenRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val tokenRepository: TokenRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken: String
        runBlocking {
            accessToken = tokenRepository.readToken()
        }
        val request = chain.request().newBuilder()
            .apply {
                if (accessToken.isNotEmpty())
                    header("Authorization", "Bearer $accessToken")
            }
            .build()

        return chain.proceed(request)
    }
}