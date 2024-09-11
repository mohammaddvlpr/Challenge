package com.jabama.challenge.domain.usecase.login

import com.jabama.challenge.network.oauth.RequestAccessToken
import com.jabama.challenge.repository.oauth.AccessTokenDataSource
import com.jabama.challenge.repository.token.TokenRepository
import com.jabama.challenge.ui.main.CLIENT_ID
import com.jabama.challenge.ui.main.CLIENT_SECRET
import com.jabama.challenge.ui.main.REDIRECT_URI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetAccessTokenUseCase(
    private val tokenRepository: TokenRepository,
    private val accessTokenDataSource: AccessTokenDataSource
) {


    suspend operator fun invoke(authorizationCode: String) {
        val response = accessTokenDataSource.accessToken(
            RequestAccessToken(
                CLIENT_ID,
                CLIENT_SECRET,
                authorizationCode,
                REDIRECT_URI,
                "0"
            )
        )

//        todo: replace async in repo with suspend fun and uncomment
//        tokenRepository.saveToken(response.accessToken)
    }

}

}