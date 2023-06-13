package com.example.vaccinationcontrol.ui.main.vaccinations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.domain.models.Passport
import com.example.vaccinationcontrol.domain.models.Vaccination
import com.example.vaccinationcontrol.domain.repositories.PassportRepository
import com.example.vaccinationcontrol.domain.repositories.VaccinationRepository
import kotlinx.coroutines.launch

class VaccinationViewModel(
    private val vaccinationRepository: VaccinationRepository
) : ViewModel() {

    private val _vaccinations = MutableLiveData<List<Vaccination>>()
    val vaccinations: LiveData<List<Vaccination>> = _vaccinations

    fun getVaccinationsByUserId(userId: Int) {
        viewModelScope.launch {
            try {
                _vaccinations.value = vaccinationRepository.getVaccinationsByUserId(userId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}