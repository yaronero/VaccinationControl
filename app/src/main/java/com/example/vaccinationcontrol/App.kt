package com.example.vaccinationcontrol

import com.example.vaccinationcontrol.di.dataModule
import com.example.vaccinationcontrol.di.viewModelModule
import com.zeugmasolutions.localehelper.LocaleAwareApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : LocaleAwareApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, viewModelModule))
        }
    }
}