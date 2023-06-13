package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.vaccine.Vaccines
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VaccineApi {

    @GET("vaccines/")
    suspend fun getVaccineById(
        @Query("id") vaccineId: Int
    ): Response<Vaccines>
}