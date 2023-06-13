package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.employee.Employees
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EmployeeApi {

    @GET("employees/")
    suspend fun getEmployeeById(
        @Query("id") employeeId: Int
    ): Response<Employees>
}