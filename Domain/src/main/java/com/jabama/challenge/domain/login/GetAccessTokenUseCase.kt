package com.jabama.challenge.domain.login

import com.jabama.challenge.domain.accessToken.TokenRepository
import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI


class GetAccessTokenUseCase(
    private val tokenRepository: TokenRepository,
    private val authRepository: AuthRepository
) {


    suspend operator fun invoke(authorizationCode: String): Boolean {
        val response = authRepository.accessToken(
            RequestAccessTokenDomainModel(
                CLIENT_ID,
                CLIENT_SECRET,
                authorizationCode,
                REDIRECT_URI,
                "0"
            )
        )

        val result = response.getOrNull()

        return if (result != null && response.isSuccess) {
            tokenRepository.saveToken(result.accessToken)
            true

        } else
            false
    }

}

