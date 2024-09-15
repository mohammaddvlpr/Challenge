package com.jabama.challenge.domain.auth

import com.jabama.challenge.domain.auth.models.ResponseAccessTokenDomainModel

interface AuthRepository {
    suspend fun accessToken(authorizationCode:String): Result<ResponseAccessTokenDomainModel>
    fun getAuthorizationUrl(): String
}