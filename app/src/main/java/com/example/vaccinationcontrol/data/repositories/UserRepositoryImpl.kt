package com.example.vaccinationcontrol.data.repositories

import com.example.vaccinationcontrol.data.api.TokenInterceptor
import com.example.vaccinationcontrol.data.api.apis.UserApi
import com.example.vaccinationcontrol.data.mappers.UserMapper
import com.example.vaccinationcontrol.domain.models.User
import com.example.vaccinationcontrol.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val tokenInterceptor: TokenInterceptor,
    private val userMapper: UserMapper
): UserRepository {

    override suspend fun getUser(): User {
        val users = userApi.getUsers()
        val email = tokenInterceptor.getEmail()
        val userItem = users.body()?.find { it.email == email }!!

        return userMapper.mapUserItemToUserModel(userItem)
    }
}