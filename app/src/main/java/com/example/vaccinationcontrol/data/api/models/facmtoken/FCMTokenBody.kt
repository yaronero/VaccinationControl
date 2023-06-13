package com.example.vaccinationcontrol.data.api.models.facmtoken

import com.google.gson.annotations.SerializedName

data class FCMTokenBody(
    @SerializedName("token") val token: String,
    @SerializedName("user_id") val userId: Int,
)
