package com.jabama.challenge.domain.accessToken


class GetIsLoginUseCase(
    private val preferencesRepository: PreferencesRepository,
) {
    suspend operator fun invoke(): Boolean {
        return preferencesRepository.readToken().isNotEmpty()
    }

}

