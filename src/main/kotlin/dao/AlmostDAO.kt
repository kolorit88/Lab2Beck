package org.example.example.dao

import dto.User
import java.util.concurrent.ConcurrentHashMap

object AlmostDAO {
    private val users: MutableMap<String, User> = ConcurrentHashMap()

    fun getUserById(id: String) : User? {
        return users[id]
    }

    fun addUser(user: User) {
        users[user.id] = user
    }

}