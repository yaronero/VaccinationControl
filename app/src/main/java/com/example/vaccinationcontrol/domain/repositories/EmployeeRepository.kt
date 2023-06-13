package com.example.vaccinationcontrol.domain.repositories

import com.example.vaccinationcontrol.domain.models.Employee

interface EmployeeRepository {

    suspend fun getEmployeeById(id: Int): Employee
}