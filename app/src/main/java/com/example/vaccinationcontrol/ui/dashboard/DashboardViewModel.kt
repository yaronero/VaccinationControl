package com.example.vaccinationcontrol.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.example.vaccinationcontrol.domain.repositories.UserRepository
import com.example.vaccinationcontrol.utils.TokenState
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val userRepository: UserRepository,
    private val tokenInterceptor: TokenInterceptor
) : ViewModel() {

    private val _tokenState = MutableLiveData<TokenState>()
    val tokenState: LiveData<TokenState> = _tokenState

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val token = sharedPrefsRepository.getUserToken()
                token?.let {
                    tokenInterceptor.updateToken(token)
                }
                userRepository.getUser()
                _tokenState.value = TokenState.WorkingJWT
                _isLoading.value = false
            } catch (e: Exception) {
                _tokenState.value = TokenState.ExpiredJWT
                _isLoading.value = false
            }
        }
    }
}