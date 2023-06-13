package com.example.vaccinationcontrol.data.api.models.vaccine

import com.google.gson.annotations.SerializedName

data class VaccineItem(
    @SerializedName("count") val count: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("description") val description: String,
    @SerializedName("expiration_date") val expiration_date: String,
    @SerializedName("id") val id: Int,
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("name") val name: String,
    @SerializedName("updatedAt") val updatedAt: String
)