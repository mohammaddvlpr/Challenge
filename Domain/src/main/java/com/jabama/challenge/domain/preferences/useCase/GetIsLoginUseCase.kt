package com.jabama.challenge.domain.preferences.useCase

import com.jabama.challenge.domain.preferences.PreferencesRepository


class GetIsLoginUseCase(
    private val preferencesRepository: PreferencesRepository,
) {
    suspend operator fun invoke(): Boolean {
        return preferencesRepository.readToken().isNotEmpty()
    }

}

