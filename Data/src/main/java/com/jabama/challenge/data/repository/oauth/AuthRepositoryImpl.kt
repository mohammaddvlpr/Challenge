package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.AuthService
import com.jabama.challenge.data.network.oauth.RequestAccessToken

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {
    override suspend fun accessToken(requestAccessToken: RequestAccessToken) = authService.accessToken(requestAccessToken)
}