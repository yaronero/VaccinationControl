package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.apis.VaccinationApi
import com.example.vaccinationcontrol.data.mappers.VaccinationMapper
import com.example.vaccinationcontrol.domain.models.Vaccination
import com.example.vaccinationcontrol.domain.repositories.VaccinationRepository

class VaccinationRepositoryImpl(
    private val vaccinationApi: VaccinationApi,
    private val vaccinationMapper: VaccinationMapper
) : VaccinationRepository {

    override suspend fun getVaccinationsByUserId(userId: Int): List<Vaccination> {
        val vaccinations = vaccinationApi.getVaccinations()
        val vaccinationItems = vaccinations.body()?.filter { it.user_id == userId }

        return vaccinationMapper.mapVaccinationItemListToVaccinationModelList(
            vaccinationItems ?: listOf()
        )
    }
}