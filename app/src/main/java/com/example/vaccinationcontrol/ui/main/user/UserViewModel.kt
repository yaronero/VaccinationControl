package com.example.vaccinationcontrol.ui.main.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.domain.models.User
import com.example.vaccinationcontrol.domain.repositories.FCMTokenRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.example.vaccinationcontrol.domain.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val fcmTokenRepository: FCMTokenRepository
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _user.value = userRepository.getUser()
                user.value?.id?.let { id ->
                    sharedPrefsRepository.putUserId(id)
                }
                val fcmToken = sharedPrefsRepository.getUserFCMToken()
                fcmToken?.let { token ->
                    fcmTokenRepository.saveFcmToken(token, user.value?.id!!)
                }
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                e.printStackTrace()
            }
        }
    }
}