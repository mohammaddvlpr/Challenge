package com.jabama.challenge.data.network

import com.jabama.challenge.domain.preferences.PreferencesRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val preferencesRepository: PreferencesRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken: String
        runBlocking {
            accessToken = preferencesRepository.readToken()
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