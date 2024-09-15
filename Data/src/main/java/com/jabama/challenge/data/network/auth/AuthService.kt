package com.jabama.challenge.data.network.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers("Accept:application/json")
    @POST("https://github.com/login/oauth/access_token")
    suspend fun accessToken(@Body requestAccessToken: RequestAccessToken) : Response<ResponseAccessToken>
}