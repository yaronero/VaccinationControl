package com.example.vaccinationcontrol.utils

import android.content.Context
import com.example.vaccinationcontrol.R

fun decodeGender(gender: String, context: Context): String {
   return when(gender.lowercase()) {
        "m" -> context.getString(R.string.male)
        "f" -> context.getString(R.string.female)
       else -> ""
   }
}