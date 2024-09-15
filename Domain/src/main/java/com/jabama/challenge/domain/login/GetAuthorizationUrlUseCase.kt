package com.jabama.challenge.domain.login

class GetAuthorizationUrlUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(): String {
        return authRepository.getAuthorizationUrl()
    }
}