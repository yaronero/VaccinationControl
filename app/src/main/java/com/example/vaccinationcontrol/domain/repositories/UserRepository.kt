package com.example.vaccinationcontrol.domain.repositories

import com.example.vaccinationcontrol.domain.models.User

interface UserRepository {

    suspend fun getUser(): User
}