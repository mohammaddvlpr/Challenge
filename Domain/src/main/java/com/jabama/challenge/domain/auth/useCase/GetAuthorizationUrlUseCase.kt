package com.jabama.challenge.domain.auth.useCase

import com.jabama.challenge.domain.auth.AuthRepository

class GetAuthorizationUrlUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(): String {
        return authRepository.getAuthorizationUrl()
    }
}