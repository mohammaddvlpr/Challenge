package com.jabama.challenge.domain.login

import com.jabama.challenge.domain.accessToken.TokenRepository
import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI


class GetAccessTokenUseCase(
    private val tokenRepository: TokenRepository,
    private val accessTokenDataSource: AccessTokenDataSource
) {


    suspend operator fun invoke(authorizationCode: String): Boolean {
        val response = accessTokenDataSource.accessToken(
            RequestAccessToken(
                CLIENT_ID,
                CLIENT_SECRET,
                authorizationCode,
                REDIRECT_URI,
                "0"
            )
        )

        val body = response.body()

        return if (body != null && response.isSuccessful) {
            tokenRepository.saveToken(body.accessToken)
            true

        } else
            false
    }

}

