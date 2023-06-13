package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.vaccination.Vaccinations
import retrofit2.Response
import retrofit2.http.GET

interface VaccinationApi {

    @GET("vaccinations/")
    suspend fun getVaccinations(): Response<Vaccinations>
}