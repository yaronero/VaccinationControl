package com.example.vaccinationcontrol.data.api.models.vaccination

import com.google.gson.annotations.SerializedName

data class VaccinationItem(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("employee_id") val employee_id: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("notes") val notes: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("user_id") val user_id: Int,
    @SerializedName("vaccination_date") val vaccination_date: String,
    @SerializedName("vaccination_location") val vaccination_location: String,
    @SerializedName("vaccine_id") val vaccine_id: Int
)