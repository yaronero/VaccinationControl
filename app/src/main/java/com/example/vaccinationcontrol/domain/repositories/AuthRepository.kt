package com.example.vaccinationcontrol.domain.repositories

interface AuthRepository {

    suspend fun login(email: String, password: String): String?
}