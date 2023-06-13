package com.example.vaccinationcontrol.data.api.retrofit

import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance(
    private val tokenInterceptor: TokenInterceptor
) {

    fun getInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(tokenInterceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    companion object {
        private const val BROADCAST_ADDRESS = "10.0.2.2"
//        private const val BROADCAST_ADDRESS = "192.168.0.104"
        private const val BASE_URL = "http://$BROADCAST_ADDRESS:3000/"
    }
}