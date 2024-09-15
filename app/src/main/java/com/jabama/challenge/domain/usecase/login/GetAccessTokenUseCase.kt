package com.jabama.challenge.domain.usecase.login

import com.jabama.challenge.data.network.oauth.RequestAccessToken
import com.jabama.challenge.data.repository.oauth.AccessTokenDataSource
import com.jabama.challenge.data.repository.token.TokenRepository
import com.jabama.challenge.ui.main.CLIENT_ID
import com.jabama.challenge.ui.main.CLIENT_SECRET
import com.jabama.challenge.ui.main.REDIRECT_URI

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

