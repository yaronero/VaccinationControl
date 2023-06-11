package com.example.vaccinationcontrol.di

import com.example.vaccinationcontrol.data.api.apis.AuthApi
import com.example.vaccinationcontrol.data.api.retrofit.RetrofitInstance
import com.example.vaccinationcontrol.data.repositories.AuthRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.SharedPrefsRepositoryImpl
import com.example.vaccinationcontrol.domain.repositories.AuthRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        RetrofitInstance()
    }

    single<AuthApi> {
        (get() as RetrofitInstance).getInstance().create(AuthApi::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(get())
    }
}