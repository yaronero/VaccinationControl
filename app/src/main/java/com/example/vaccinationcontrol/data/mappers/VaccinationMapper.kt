package com.example.vaccinationcontrol.data.mappers

import com.example.vaccinationcontrol.data.api.models.vaccination.VaccinationItem
import com.example.vaccinationcontrol.domain.models.Vaccination

class VaccinationMapper {

    fun mapVaccinationItemToVaccinationModel(vaccinationItem: VaccinationItem): Vaccination {
        return Vaccination(
            id = vaccinationItem.id,
            userId = vaccinationItem.user_id,
            employeeId = vaccinationItem.employee_id,
            vaccineId = vaccinationItem.vaccine_id,
            notes = vaccinationItem.notes,
            vaccinationDate = vaccinationItem.vaccination_date,
            vaccinationLocation = vaccinationItem.vaccination_location,
            createdAt = vaccinationItem.createdAt,
            updatedAt = vaccinationItem.createdAt
        )
    }

    fun mapVaccinationItemListToVaccinationModelList(vaccinationItems: List<VaccinationItem>): List<Vaccination> {
        return vaccinationItems.map { vaccinationItem ->
            mapVaccinationItemToVaccinationModel(vaccinationItem)
        }
    }
}