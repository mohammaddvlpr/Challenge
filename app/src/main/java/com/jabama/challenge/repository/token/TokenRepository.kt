package com.jabama.challenge.repository.token

interface TokenRepository {
    suspend fun saveToken(token: String)
    suspend fun readToken(): String
}