package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.example.vaccinationcontrol.data.api.apis.AuthApi
import com.example.vaccinationcontrol.data.api.models.login.LoginBody
import com.example.vaccinationcontrol.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val tokenInterceptor: TokenInterceptor
) : AuthRepository {

    override suspend fun login(email: String, password: String): String {
        val request = authApi.login(LoginBody(email, password))
        val token = request.body()?.token ?: ""
        tokenInterceptor.updateToken(token)
        return token
    }
}