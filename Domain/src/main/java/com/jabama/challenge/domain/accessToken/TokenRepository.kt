package com.jabama.challenge.domain.accessToken

interface TokenRepository {
    fun saveToken(token: String)
    suspend fun readToken(): String
}