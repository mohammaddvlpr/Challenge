package com.jabama.challenge.data.repository.oauth

import com.jabama.challenge.data.network.oauth.RequestAccessToken
import com.jabama.challenge.data.network.oauth.ResponseAccessToken
import com.jabama.challenge.domain.login.RequestAccessTokenDomainModel
import com.jabama.challenge.domain.login.ResponseAccessTokenDomainModel

class AuthMapper {

    fun toData(requestAccessTokenDomainModel: RequestAccessTokenDomainModel): RequestAccessToken {
        return RequestAccessToken(
            clientId = requestAccessTokenDomainModel.clientId,
            clientSecret = requestAccessTokenDomainModel.clientSecret,
            code = requestAccessTokenDomainModel.code,
            redirectUri = requestAccessTokenDomainModel.redirectUri,
            state = requestAccessTokenDomainModel.state,
        )
    }

    fun toDomain(responseAccessToken: ResponseAccessToken): ResponseAccessTokenDomainModel {
        return ResponseAccessTokenDomainModel(
            accessToken = responseAccessToken.accessToken,
            tokenType = responseAccessToken.tokenType
        )
    }
}