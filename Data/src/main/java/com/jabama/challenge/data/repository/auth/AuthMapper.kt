package com.jabama.challenge.data.repository.auth

import com.jabama.challenge.data.network.auth.models.ResponseAccessToken
import com.jabama.challenge.domain.auth.models.ResponseAccessTokenDomainModel

class AuthMapper {
    fun toDomain(responseAccessToken: ResponseAccessToken): ResponseAccessTokenDomainModel {
        return ResponseAccessTokenDomainModel(
            accessToken = responseAccessToken.accessToken,
            tokenType = responseAccessToken.tokenType
        )
    }
}