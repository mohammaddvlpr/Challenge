package com.jabama.challenge.data.repository.token

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TOKEN = "TOKEN"

class TokenRepositoryImpl(private val sharedPreferences: SharedPreferences) : TokenRepository {
    override fun saveToken(token: String) {
        sharedPreferences.edit().apply { putString(TOKEN, token) }.apply()
    }


    override suspend fun readToken(): String =
        withContext(Dispatchers.IO) { sharedPreferences.getString(TOKEN, "") ?: "" }
}