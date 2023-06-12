package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.passport.Passports
import retrofit2.Response
import retrofit2.http.GET

interface PassportApi {

    @GET("passports/")
    suspend fun getPassports(): Response<Passports>
}