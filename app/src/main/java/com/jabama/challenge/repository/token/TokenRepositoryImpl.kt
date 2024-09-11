package com.jabama.challenge.repository.token

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TOKEN = "TOKEN"

class TokenRepositoryImpl(private val sharedPreferences: SharedPreferences) : TokenRepository {
    override suspend fun saveToken(token: String) =
        withContext(Dispatchers.IO) {
            sharedPreferences.edit().apply { putString(TOKEN, token) }.apply()
        }


    override suspend fun readToken(): String =
        withContext(Dispatchers.IO) { sharedPreferences.getString(TOKEN, "") ?: "" }
}