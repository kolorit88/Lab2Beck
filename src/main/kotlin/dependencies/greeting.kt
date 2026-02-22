package org.example.example.dependencies

import dto.User
import dto.UserData
import java.util.*

fun createNewUser(userData: UserData) : User
{
    val userId = UUID.randomUUID().toString()
    val user = User(
        id = userId,
        name = userData.name,
        surname = userData.surname
    )

    return user
}