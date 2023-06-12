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

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                _token.value = authRepository.login(email, password)
                sharedPrefsRepository.putUserToken(token.value)
            } catch (e: Exception) {
                _error.value = "Wrong email or password"
            }
        }
    }
}