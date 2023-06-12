package com.example.vaccinationcontrol.di

import com.example.vaccinationcontrol.ui.dashboard.DashboardViewModel
import com.example.vaccinationcontrol.ui.auth.login.LoginViewModel
import com.example.vaccinationcontrol.ui.main.passport.PassportViewModel
import com.example.vaccinationcontrol.ui.main.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DashboardViewModel(get(), get(), get())
    }

    viewModel {
        LoginViewModel(get(), get())
    }

    viewModel {
        UserViewModel(get())
    }

    viewModel {
        PassportViewModel(get())
    }
}