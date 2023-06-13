package com.example.vaccinationcontrol.domain.models

data class VaccinationFullInfo(
    val id: Int,
    val vaccine: Vaccine,
    val employee: Employee,
    val notes: String,
    val userId: Int,
    val vaccinationDate: String,
    val vaccinationLocation: String,
)