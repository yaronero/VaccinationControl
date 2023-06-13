package com.example.vaccinationcontrol.domain.repositories

import com.example.vaccinationcontrol.domain.models.Vaccine

interface VaccineRepository {

    suspend fun getVaccineById(id: Int): Vaccine
}