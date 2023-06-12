package com.example.vaccinationcontrol.data.api

import com.example.vaccinationcontrol.data.getEmailFromToken
import okhttp3.Interceptor
import okhttp3.Response


class TokenInterceptor : Interceptor {

    private var token: String = ""

    fun updateToken(newToken: String) {
        token = newToken
    }

    fun getEmail(): String {
        return getEmailFromToken(token)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(modifiedRequest)
    }
}