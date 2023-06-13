package com.example.vaccinationcontrol.ui.main.vaccinations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaccinationcontrol.domain.models.VaccinationFullInfo
import com.example.vaccinationcontrol.domain.repositories.EmployeeRepository
import com.example.vaccinationcontrol.domain.repositories.VaccinationRepository
import com.example.vaccinationcontrol.domain.repositories.VaccineRepository
import kotlinx.coroutines.launch

class VaccinationViewModel(
    private val vaccinationRepository: VaccinationRepository,
    private val vaccineRepository: VaccineRepository,
    private val employeeRepository: EmployeeRepository
) : ViewModel() {

    private val _vaccinationsFull = MutableLiveData<List<VaccinationFullInfo>>()
    val vaccinationsFull: LiveData<List<VaccinationFullInfo>> = _vaccinationsFull

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getVaccinationsByUserId(userId: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val vaccinations = vaccinationRepository.getVaccinationsByUserId(userId)

                _vaccinationsFull.value = vaccinations.map { vaccination ->
                    VaccinationFullInfo(
                        id = vaccination.id,
                        vaccine = vaccineRepository.getVaccineById(vaccination.vaccineId),
                        employee = employeeRepository.getEmployeeById(vaccination.employeeId),
                        userId = vaccination.userId,
                        notes = vaccination.notes,
                        vaccinationDate = vaccination.vaccinationDate,
                        vaccinationLocation = vaccination.vaccinationLocation
                    )
                }
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                e.printStackTrace()
            }
        }
    }
}