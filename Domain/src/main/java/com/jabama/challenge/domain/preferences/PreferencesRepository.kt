package com.jabama.challenge.domain.preferences

interface PreferencesRepository {
    fun saveToken(token: String)
    suspend fun readToken(): String
}