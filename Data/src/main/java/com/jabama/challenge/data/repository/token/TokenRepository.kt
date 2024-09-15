package com.jabama.challenge.data.repository.token

interface TokenRepository {
    fun saveToken(token: String)
    suspend fun readToken(): String
}