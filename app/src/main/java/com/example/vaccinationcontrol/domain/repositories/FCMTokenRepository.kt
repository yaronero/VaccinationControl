package com.example.vaccinationcontrol.domain.repositories

interface FCMTokenRepository {

    suspend fun saveFcmToken(token: String, userId: Int)
}