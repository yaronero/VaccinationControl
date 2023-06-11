package com.example.vaccinationcontrol.ui.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.domain.repositories.AuthRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val sharedPrefsRepository: SharedPrefsRepository
) : ViewModel() {

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _token.value = authRepository.login(email, password)
            sharedPrefsRepository.putUserToken(token.value)
        }
    }
}