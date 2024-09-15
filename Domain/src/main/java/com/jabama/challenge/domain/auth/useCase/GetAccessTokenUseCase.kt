package com.jabama.challenge.domain.auth.useCase

import com.jabama.challenge.domain.auth.AuthRepository
import com.jabama.challenge.domain.preferences.PreferencesRepository


class GetAccessTokenUseCase(
    private val preferencesRepository: PreferencesRepository,
    private val authRepository: AuthRepository
) {


    suspend operator fun invoke(authorizationCode: String): Boolean {
        val response = authRepository.accessToken(
            authorizationCode)


        val result = response.getOrNull()

        return if (result != null && response.isSuccess) {
            preferencesRepository.saveToken(result.accessToken)
            true

        } else
            false
    }

}

