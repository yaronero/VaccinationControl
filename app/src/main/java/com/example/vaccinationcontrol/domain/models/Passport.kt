package com.example.vaccinationcontrol.domain.models

data class Passport(
    val country: String,
    val createdAt: String,
    val expirationDate: String,
    val id: Int,
    val notes: String,
    val passportNumber: String,
    val updatedAt: String,
    val userId: Int
)