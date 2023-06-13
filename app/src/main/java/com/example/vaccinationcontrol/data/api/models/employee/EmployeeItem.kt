package com.example.vaccinationcontrol.data.api.models.employee

import com.google.gson.annotations.SerializedName

data class EmployeeItem(
    @SerializedName("address") val address: String,
    @SerializedName("age") val age: Int,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("contact_number") val contact_number: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("license_number") val license_number: String,
    @SerializedName("password") val password: String,
    @SerializedName("phone_number") val phone_number: String,
    @SerializedName("registration_date") val registration_date: String,
    @SerializedName("specialization") val specialization: String,
    @SerializedName("status") val status: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("username") val username: String
)