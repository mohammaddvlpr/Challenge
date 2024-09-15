package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.RequestAccessToken
import com.jabama.challenge.data.network.oauth.ResponseAccessToken
import retrofit2.Response

interface AccessTokenDataSource {
    suspend fun accessToken(requestAccessToken: RequestAccessToken): Response<ResponseAccessToken>
}