package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.facmtoken.FCMTokenBody
import retrofit2.http.Body
import retrofit2.http.POST

interface FCMTokenApi {

    @POST("mobile/api/save-token/")
    suspend fun sendTokenWithUserId(
        @Body tokenBody: FCMTokenBody
    )
}