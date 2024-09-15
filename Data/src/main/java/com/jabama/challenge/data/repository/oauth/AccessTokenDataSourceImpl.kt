package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.AccessTokenService
import com.jabama.challenge.data.network.oauth.RequestAccessToken

class AccessTokenDataSourceImpl(private val accessTokenService: AccessTokenService) : AccessTokenDataSource {
    override suspend fun accessToken(requestAccessToken: RequestAccessToken) = accessTokenService.accessToken(requestAccessToken)
}