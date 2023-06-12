package com.example.vaccinationcontrol.di

import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.example.vaccinationcontrol.data.api.apis.AuthApi
import com.example.vaccinationcontrol.data.api.apis.PassportApi
import com.example.vaccinationcontrol.data.api.apis.UserApi
import com.example.vaccinationcontrol.data.api.retrofit.RetrofitInstance
import com.example.vaccinationcontrol.data.repositories.AuthRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.PassportRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.SharedPrefsRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.UserRepositoryImpl
import com.example.vaccinationcontrol.domain.repositories.AuthRepository
import com.example.vaccinationcontrol.domain.repositories.PassportRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.example.vaccinationcontrol.domain.repositories.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        TokenInterceptor()
    }

    single {
        RetrofitInstance(get())
    }

    single<AuthApi> {
        (get() as RetrofitInstance).getInstance().create(AuthApi::class.java)
    }

    single<UserApi> {
        (get() as RetrofitInstance).getInstance().create(UserApi::class.java)
    }

    single<PassportApi> {
        (get() as RetrofitInstance).getInstance().create(PassportApi::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get(), get())
    }

    single<PassportRepository> {
        PassportRepositoryImpl(get())
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(get())
    }
}