package com.example.vaccinationcontrol.utils

sealed class TokenState {
    object WorkingJWT : TokenState()
    object ExpiredJWT : TokenState()
}