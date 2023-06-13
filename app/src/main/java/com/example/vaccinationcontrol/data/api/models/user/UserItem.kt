package com.example.vaccinationcontrol.data.api.models.user

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("address") val address: String,
    @SerializedName("age") val age: Int,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("password") val password: String,
    @SerializedName("phone_number") val phone_number: String,
    @SerializedName("registration_date") val registration_date: String,
    @SerializedName("status") val status: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("username") val username: String
)