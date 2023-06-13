package com.example.vaccinationcontrol.data.api.models.passport

import com.google.gson.annotations.SerializedName

data class PassportItem(
    @SerializedName("country") val country: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("expiration_date") val expiration_date: String,
    @SerializedName("id") val id: Int,
    @SerializedName("notes") val notes: String,
    @SerializedName("passport_number") val passport_number: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("user_id") val user_id: Int
)