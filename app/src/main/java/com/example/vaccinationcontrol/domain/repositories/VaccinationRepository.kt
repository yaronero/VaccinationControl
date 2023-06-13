package com.example.vaccinationcontrol.domain.repositories

import com.example.vaccinationcontrol.domain.models.Vaccination

interface VaccinationRepository {

    suspend fun getVaccinationsByUserId(userId: Int): List<Vaccination>
}