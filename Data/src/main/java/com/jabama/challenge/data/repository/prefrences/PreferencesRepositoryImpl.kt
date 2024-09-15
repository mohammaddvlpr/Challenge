package com.jabama.challenge.data.repository.prefrences

import com.jabama.challenge.domain.accessToken.PreferencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TOKEN = "TOKEN"

class PreferencesRepositoryImpl(private val sharedPreferences: SharedPreferences) : PreferencesRepository {
    override fun saveToken(token: String) {
        sharedPreferences.edit().apply { putString(TOKEN, token) }.apply()
    }


    override suspend fun readToken(): String =
        withContext(Dispatchers.IO) { sharedPreferences.getString(TOKEN, "") ?: "" }
}