package com.example.vaccinationcontrol.data.mappers

import com.example.vaccinationcontrol.data.api.models.user.UserItem
import com.example.vaccinationcontrol.domain.models.User

class UserMapper {

    fun mapUserItemToUserModel(userItem: UserItem): User {
        return User(
            id = userItem.id,
            username = userItem.username,
            email = userItem.email,
            password = userItem.password,
            age = userItem.age,
            avatar = userItem.avatar,
            address = userItem.address,
            gender = userItem.gender,
            firstName = userItem.first_name,
            lastName = userItem.last_name,
            phoneNumber = userItem.phone_number,
            registration_date = userItem.registration_date,
            status = userItem.email,
            createdAt = userItem.createdAt,
            updatedAt = userItem.createdAt
            )
    }
}