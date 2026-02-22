package org.example.example.controller

import dto.GreetingMain
import dto.User
import dto.UserData
import org.example.example.dao.AlmostDAO
import org.example.example.dependencies.createNewUser
import org.example.example.dto.GreetingUser

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/greeting")
class HelloController {

    @GetMapping
    fun getGreeting(): ResponseEntity<GreetingMain> {
        return ResponseEntity.ok(GreetingMain())
    }

    @GetMapping(params = ["id"])
    fun getUserData(@RequestParam id: String): ResponseEntity<*> {
        val user: User? = AlmostDAO.getUserById(id)

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found")
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserData(user.name, user.surname))
    }

    @GetMapping("/{id}")
    fun getUserDataByPath(@PathVariable id: String): ResponseEntity<*> {
        return getUserData(id)
    }

    @PostMapping
    fun createUser(@RequestBody userData: UserData): ResponseEntity<GreetingUser> {
        val newUser: User = createNewUser(userData)
        AlmostDAO.addUser(newUser)

        return ResponseEntity.ok(GreetingUser(newUser.id ,
            "Hello, ${newUser.name} ${newUser.surname}"))
    }

}