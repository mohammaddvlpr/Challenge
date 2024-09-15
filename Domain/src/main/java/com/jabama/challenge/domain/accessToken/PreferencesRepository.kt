package com.jabama.challenge.domain.accessToken

interface PreferencesRepository {
    fun saveToken(token: String)
    suspend fun readToken(): String
}