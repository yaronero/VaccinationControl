package com.example.vaccinationcontrol

import com.example.vaccinationcontrol.di.dataModule
import com.example.vaccinationcontrol.di.viewModelModule
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.google.firebase.messaging.FirebaseMessaging
import com.zeugmasolutions.localehelper.LocaleAwareApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : LocaleAwareApplication() {

    private val sharedPrefsRepository: SharedPrefsRepository by inject()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, viewModelModule))
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if(!task.isSuccessful) {
                return@addOnCompleteListener
            }
            coroutineScope.launch {
                sharedPrefsRepository.putUserFCMToken(task.result)
            }
        }
    }
}