package com.example.vaccinationcontrol.di

import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.example.vaccinationcontrol.data.api.apis.AuthApi
import com.example.vaccinationcontrol.data.api.apis.EmployeeApi
import com.example.vaccinationcontrol.data.api.apis.PassportApi
import com.example.vaccinationcontrol.data.api.apis.UserApi
import com.example.vaccinationcontrol.data.api.apis.VaccinationApi
import com.example.vaccinationcontrol.data.api.apis.VaccineApi
import com.example.vaccinationcontrol.data.api.retrofit.RetrofitInstance
import com.example.vaccinationcontrol.data.mappers.EmployeeMapper
import com.example.vaccinationcontrol.data.mappers.PassportMapper
import com.example.vaccinationcontrol.data.mappers.UserMapper
import com.example.vaccinationcontrol.data.mappers.VaccinationMapper
import com.example.vaccinationcontrol.data.mappers.VaccineMapper
import com.example.vaccinationcontrol.data.repositories.AuthRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.EmployeeRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.PassportRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.SharedPrefsRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.UserRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.VaccinationRepositoryImpl
import com.example.vaccinationcontrol.data.repositories.VaccineRepositoryImpl
import com.example.vaccinationcontrol.domain.repositories.AuthRepository
import com.example.vaccinationcontrol.domain.repositories.EmployeeRepository
import com.example.vaccinationcontrol.domain.repositories.PassportRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.example.vaccinationcontrol.domain.repositories.UserRepository
import com.example.vaccinationcontrol.domain.repositories.VaccinationRepository
import com.example.vaccinationcontrol.domain.repositories.VaccineRepository
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

    single<VaccinationApi> {
        (get() as RetrofitInstance).getInstance().create(VaccinationApi::class.java)
    }

    single<VaccineApi> {
        (get() as RetrofitInstance).getInstance().create(VaccineApi::class.java)
    }

    single<EmployeeApi> {
        (get() as RetrofitInstance).getInstance().create(EmployeeApi::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get(), get(), get())
    }

    single<PassportRepository> {
        PassportRepositoryImpl(get(), get())
    }

    single<VaccinationRepository> {
        VaccinationRepositoryImpl(get(), get())
    }

    single<VaccineRepository> {
        VaccineRepositoryImpl(get(), get())
    }

    single<EmployeeRepository> {
        EmployeeRepositoryImpl(get(), get())
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(get())
    }

    single {
        UserMapper()
    }

    single {
        PassportMapper()
    }

    single {
        VaccinationMapper()
    }

    single {
        VaccineMapper()
    }

    single {
        EmployeeMapper()
    }
}