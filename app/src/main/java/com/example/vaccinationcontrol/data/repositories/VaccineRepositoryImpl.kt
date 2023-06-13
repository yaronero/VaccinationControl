package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.apis.VaccineApi
import com.example.vaccinationcontrol.data.mappers.VaccineMapper
import com.example.vaccinationcontrol.domain.models.Vaccine
import com.example.vaccinationcontrol.domain.repositories.VaccineRepository

class VaccineRepositoryImpl(
    private val vaccineApi: VaccineApi,
    private val vaccineMapper: VaccineMapper
) : VaccineRepository {

    override suspend fun getVaccineById(id: Int): Vaccine {
        val vaccines = vaccineApi.getVaccineById(id)
        val vaccineItem = vaccines.body()?.find { it.id == id }!!

        return vaccineMapper.mapVaccineItemToVaccineModel(
            vaccineItem
        )
    }
}