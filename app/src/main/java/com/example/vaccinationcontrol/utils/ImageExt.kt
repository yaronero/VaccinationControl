package com.example.vaccinationcontrol.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.src(uri: String) {
    Glide.with(context)
        .load(uri)
        .into(this)
}