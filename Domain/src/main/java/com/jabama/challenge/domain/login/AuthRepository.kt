package com.jabama.challenge.domain.login

interface AuthRepository {
    suspend fun accessToken(authorizationCode:String): Result<ResponseAccessTokenDomainModel>
    fun getAuthorizationUrl(): String
}