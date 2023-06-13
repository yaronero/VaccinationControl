package com.example.vaccinationcontrol.domain.models

data class Vaccine(
    val count: Int,
    val createdAt: String,
    val description: String,
    val expirationDate: String,
    val id: Int,
    val manufacturer: String,
    val name: String,
    val updatedAt: String
)