package com.jabama.challenge.domain.login

import com.jabama.challenge.domain.accessToken.PreferencesRepository
import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI


class GetAccessTokenUseCase(
    private val preferencesRepository: PreferencesRepository,
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
            preferencesRepository.saveToken(result.accessToken)
            true

        } else
            false
    }

}

