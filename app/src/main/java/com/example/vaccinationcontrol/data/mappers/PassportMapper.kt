package com.example.vaccinationcontrol.data.mappers

import com.example.vaccinationcontrol.data.api.models.passport.PassportItem
import com.example.vaccinationcontrol.domain.models.Passport

class PassportMapper {

    fun mapPassportItemToPassportModel(passportItem: PassportItem): Passport {
        return Passport(
            id = passportItem.id,
            userId = passportItem.user_id,
            passportNumber = passportItem.passport_number,
            notes = passportItem.notes,
            country = passportItem.country,
            expirationDate = passportItem.expiration_date,
            createdAt = passportItem.createdAt,
            updatedAt = passportItem.createdAt
        )
    }
}