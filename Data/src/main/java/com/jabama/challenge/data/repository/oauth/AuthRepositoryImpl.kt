package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.AuthService
import com.jabama.challenge.data.repository.apiCall
import com.jabama.challenge.domain.login.AuthRepository
import com.jabama.challenge.domain.login.RequestAccessTokenDomainModel
import com.jabama.challenge.domain.login.ResponseAccessTokenDomainModel

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val authMapper: AuthMapper
) : AuthRepository {
    override suspend fun accessToken(requestAccessTokenDomainModel: RequestAccessTokenDomainModel):Result<ResponseAccessTokenDomainModel> {
        val result =
            apiCall { authService.accessToken(authMapper.toData(requestAccessTokenDomainModel)) }
        val resultValue = result.getOrNull()

        return if (result.isSuccess && resultValue != null )
            Result.success(authMapper.toDomain(resultValue))
        else
            Result.failure(result.exceptionOrNull() ?: Exception("Not known"))
    }
}