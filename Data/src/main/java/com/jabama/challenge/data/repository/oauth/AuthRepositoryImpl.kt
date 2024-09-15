package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.AuthService
import com.jabama.challenge.domain.login.AuthRepository
import com.jabama.challenge.domain.login.RequestAccessTokenDomainModel

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {
    override suspend fun accessToken(requestAccessTokenDomainModel: RequestAccessTokenDomainModel) = authService.accessToken(requestAccessToken)
}