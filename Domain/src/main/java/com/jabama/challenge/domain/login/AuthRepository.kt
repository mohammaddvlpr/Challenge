package com.jabama.challenge.domain.login

interface AuthRepository {
    suspend fun accessToken(requestAccessTokenDomainModel: RequestAccessTokenDomainModel): Result<ResponseAccessTokenDomainModel>
}