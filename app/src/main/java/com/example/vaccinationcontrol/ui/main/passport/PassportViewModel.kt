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

    fun getPassportByUserId(userId: Int) {
        viewModelScope.launch {
            try {
                _passport.value = passportRepository.getPassportByUserId(userId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}