package com.jabama.challenge.data.network.oauth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AccessTokenService {
    @Headers("Accept:application/json")
    @POST("https://github.com/login/oauth/access_token")
    suspend fun accessToken(@Body requestAccessToken: RequestAccessToken) : Response<ResponseAccessToken>
}