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

    init {
        viewModelScope.launch {
            try {
                val token = sharedPrefsRepository.getUserToken()
                token?.let {
                    tokenInterceptor.updateToken(token)
                }
                userRepository.getUser()
                _tokenState.value = TokenState.WorkingJWT
            } catch (e: Exception) {
                _tokenState.value = TokenState.ExpiredJWT
            }
        }
    }
}