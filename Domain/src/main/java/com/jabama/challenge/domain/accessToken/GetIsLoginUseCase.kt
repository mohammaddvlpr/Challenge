package com.jabama.challenge.domain.accessToken

import com.jabama.challenge.data.repository.token.TokenRepository

class GetIsLoginUseCase(
    private val tokenRepository: TokenRepository,
) {
    suspend operator fun invoke(): Boolean {
        return tokenRepository.readToken().isNotEmpty()
    }

}

