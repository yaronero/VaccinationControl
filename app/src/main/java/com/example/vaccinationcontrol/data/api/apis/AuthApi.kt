package com.example.vaccinationcontrol.data.api.apis

import com.example.vaccinationcontrol.data.api.models.login.LoginBody
import com.example.vaccinationcontrol.data.api.models.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Body body: LoginBody
    ): Response<LoginResponse>
}