package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.apis.PassportApi
import com.example.vaccinationcontrol.data.mappers.PassportMapper
import com.example.vaccinationcontrol.domain.models.Passport
import com.example.vaccinationcontrol.domain.repositories.PassportRepository

class PassportRepositoryImpl(
    private val passportApi: PassportApi,
    private val passportMapper: PassportMapper
) : PassportRepository {

    override suspend fun getPassportByUserId(userId: Int): Passport {
        val passports = passportApi.getPassports()
        val passportItem = passports.body()?.find { it.user_id == userId }!!

        return passportMapper.mapPassportItemToPassportModel(passportItem)
    }
}