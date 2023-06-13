package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.user.Users
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("auth/")
    suspend fun getUsers(): Response<Users>
}