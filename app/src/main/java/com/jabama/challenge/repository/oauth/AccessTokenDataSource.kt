package com.jabama.challenge.repository.oauth

import com.jabama.challenge.network.oauth.RequestAccessToken
import com.jabama.challenge.network.oauth.ResponseAccessToken
import retrofit2.Response

interface AccessTokenDataSource {
    suspend fun accessToken(requestAccessToken: RequestAccessToken): Response<ResponseAccessToken>
}