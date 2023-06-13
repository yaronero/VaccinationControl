package com.example.vaccinationcontrol.utils

import android.content.Context
import java.util.Locale

fun getCurrentLocale(context: Context): Locale {
    return context.resources.configuration.locales[0]
}