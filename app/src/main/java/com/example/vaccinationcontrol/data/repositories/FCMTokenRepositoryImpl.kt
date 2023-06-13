package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.apis.FCMTokenApi
import com.example.vaccinationcontrol.data.api.models.facmtoken.FCMTokenBody
import com.example.vaccinationcontrol.domain.repositories.FCMTokenRepository

class FCMTokenRepositoryImpl(
    private val fcmTokenApi: FCMTokenApi
) : FCMTokenRepository {

    override suspend fun saveFcmToken(token: String, userId: Int) {
        fcmTokenApi.sendTokenWithUserId(FCMTokenBody(token, userId))
    }
}