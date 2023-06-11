package com.example.vaccinationcontrol.data.repositories

import android.content.Context
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository

class SharedPrefsRepositoryImpl(
    context: Context
) : SharedPrefsRepository {

    private val sharedPrefs = context.getSharedPreferences(USER_SHARED_PREFS, Context.MODE_PRIVATE)

    override suspend fun getUserToken(): String? {
        return sharedPrefs.getString(TOKEN, "")
    }

    override suspend fun putUserToken(token: String?) {
        sharedPrefs.edit().putString(TOKEN, token).apply()
    }

    companion object {
        private const val USER_SHARED_PREFS = "user_shared_prefs"
        private const val TOKEN = "token"
    }
}