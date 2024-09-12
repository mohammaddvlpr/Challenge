package com.jabama.challenge.repository.token

interface TokenRepository {
    fun saveToken(token: String)
    suspend fun readToken(): String
}