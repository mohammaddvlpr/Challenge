package com.jabama.challenge.data.repository.auth

import com.jabama.challenge.data.network.CLIENT_ID
import com.jabama.challenge.data.network.CLIENT_SECRET
import com.jabama.challenge.data.network.REDIRECT_URI
import com.jabama.challenge.data.network.auth.AuthService
import com.jabama.challenge.data.network.auth.models.RequestAccessToken
import com.jabama.challenge.data.repository.apiCall
import com.jabama.challenge.domain.auth.AuthRepository
import com.jabama.challenge.domain.auth.models.ResponseAccessTokenDomainModel

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val authMapper: AuthMapper
) : AuthRepository {
    override suspend fun accessToken(authorizationCode: String): Result<ResponseAccessTokenDomainModel> {
        val result =
            apiCall {
                authService.accessToken(
                    RequestAccessToken(
                        clientId = CLIENT_ID,
                        clientSecret = CLIENT_SECRET,
                        code = authorizationCode,
                        redirectUri = REDIRECT_URI,
                        state = "0"
                    )
                )
            }
        val resultValue = result.getOrNull()

        return if (result.isSuccess && resultValue != null)
            Result.success(authMapper.toDomain(resultValue))
        else
            Result.failure(result.exceptionOrNull() ?: Exception("Not known"))
    }

    override fun getAuthorizationUrl(): String {
        return "https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=repo user&state=0"
    }
}