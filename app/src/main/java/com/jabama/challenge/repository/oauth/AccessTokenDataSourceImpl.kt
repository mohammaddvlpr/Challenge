package com.jabama.challenge.repository.oauth

import com.jabama.challenge.network.oauth.AccessTokenService
import com.jabama.challenge.network.oauth.RequestAccessToken

class AccessTokenDataSourceImpl(private val accessTokenService: AccessTokenService) : AccessTokenDataSource {
    override suspend fun accessToken(requestAccessToken: RequestAccessToken) = accessTokenService.accessToken(requestAccessToken)
}