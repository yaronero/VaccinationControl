package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.apis.EmployeeApi
import com.example.vaccinationcontrol.data.mappers.EmployeeMapper
import com.example.vaccinationcontrol.domain.models.Employee
import com.example.vaccinationcontrol.domain.repositories.EmployeeRepository

class EmployeeRepositoryImpl(
    private val employeeApi: EmployeeApi,
    private val employeeMapper: EmployeeMapper
) : EmployeeRepository {

    override suspend fun getEmployeeById(id: Int): Employee {
        val employees = employeeApi.getEmployeeById(id)
        val employeeItem = employees.body()?.find { it.id == id }!!

        return employeeMapper.mapEmployeeItemToEmployeeModel(
            employeeItem
        )
    }
}