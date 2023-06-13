package com.example.vaccinationcontrol.ui.main.passport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.domain.models.Passport
import com.example.vaccinationcontrol.domain.repositories.PassportRepository
import kotlinx.coroutines.launch

class PassportViewModel(
    private val passportRepository: PassportRepository
) : ViewModel() {

    private val _passport = MutableLiveData<Passport>()
    val passport: LiveData<Passport> = _passport

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getPassportByUserId(userId: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val passportItem = passportRepository.getPassportByUserId(userId)
                _passport.value = passportItem
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                e.printStackTrace()
            }
        }
    }
}