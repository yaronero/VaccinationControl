package com.example.vaccinationcontrol.domain.models

data class Vaccination(
    val employeeId: Int,
    val id: Int,
    val notes: String,
    val userId: Int,
    val vaccinationDate: String,
    val vaccinationLocation: String,
    val vaccineId: Int
)