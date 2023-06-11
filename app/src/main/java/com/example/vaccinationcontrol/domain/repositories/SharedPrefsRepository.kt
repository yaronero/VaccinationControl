package com.example.vaccinationcontrol.domain.repositories

interface SharedPrefsRepository {

    suspend fun getUserToken(): String?

    suspend fun putUserToken(token: String?)
}