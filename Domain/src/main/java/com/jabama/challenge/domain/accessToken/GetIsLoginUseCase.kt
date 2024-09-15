package com.jabama.challenge.domain.accessToken


class GetIsLoginUseCase(
    private val tokenRepository: TokenRepository,
) {
    suspend operator fun invoke(): Boolean {
        return tokenRepository.readToken().isNotEmpty()
    }

}

