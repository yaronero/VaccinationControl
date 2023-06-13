package com.example.vaccinationcontrol.domain.repositories

import com.example.vaccinationcontrol.domain.models.Passport

interface PassportRepository {

    suspend fun getPassportByUserId(userId: Int): Passport
}