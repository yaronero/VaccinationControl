package com.example.vaccinationcontrol.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.src(uri: String) {
    Glide.with(context)
        .load(uri)
        .into(this)
}

fun ImageView.src(drawable: Drawable) {
    Glide.with(context)
        .load(drawable)
        .into(this)
}