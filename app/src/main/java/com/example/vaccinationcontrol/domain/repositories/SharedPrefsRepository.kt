package com.example.vaccinationcontrol.domain.repositories

interface SharedPrefsRepository {

    suspend fun getUserToken(): String?

    suspend fun putUserToken(token: String?)

    suspend fun getUserFCMToken(): String?

    suspend fun putUserFCMToken(fcmToken: String?)

    suspend fun getUserId(): Int

    suspend fun putUserId(userId: Int)
}