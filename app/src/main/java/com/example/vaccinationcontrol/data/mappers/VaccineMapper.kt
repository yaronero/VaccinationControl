package com.example.vaccinationcontrol.data.mappers

import com.example.vaccinationcontrol.data.api.models.vaccine.VaccineItem
import com.example.vaccinationcontrol.domain.models.Vaccine

class VaccineMapper {

    fun mapVaccineItemToVaccineModel(vaccineItem: VaccineItem): Vaccine {
        return Vaccine(
            id = vaccineItem.id,
            name = vaccineItem.name,
            manufacturer = vaccineItem.manufacturer,
            count = vaccineItem.count,
            description = vaccineItem.description,
            expirationDate = vaccineItem.expiration_date,
            createdAt = vaccineItem.createdAt,
            updatedAt = vaccineItem.createdAt
        )
    }
}