package com.example.vaccinationcontrol.domain.models

data class Vaccination(
    val createdAt: String,
    val employeeId: Int,
    val id: Int,
    val notes: String,
    val updatedAt: String,
    val userId: Int,
    val vaccinationDate: String,
    val vaccinationLocation: String,
    val vaccineId: Int
)