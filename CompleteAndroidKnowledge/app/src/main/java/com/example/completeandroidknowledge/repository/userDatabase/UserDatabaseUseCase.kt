package com.example.completeandroidknowledge.repository.userDatabase

import com.example.completeandroidknowledge.sectionPublic.model.User

interface UserDatabaseUseCase {
    fun initGetUserFromDatabase()
    fun initSaveUserInDatabase(document: String, type: String)
    fun initUpdateUser(user: User?)
}