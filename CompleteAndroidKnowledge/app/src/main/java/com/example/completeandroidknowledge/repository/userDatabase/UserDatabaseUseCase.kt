package com.example.completeandroidknowledge.repository.userDatabase

import com.example.completeandroidknowledge.section1.model.User

interface UserDatabaseUseCase {
    fun initGetUserFromDatabase()
    fun initSaveUserInDatabase(document: String, type: String)
    fun initUpdateUser(user: User?)
}