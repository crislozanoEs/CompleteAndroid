package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.model.UserDatabaseDao

class UserViewModelFactory (private val userType: String, private val userDoc: String, private val userDatabaseDao: UserDatabaseDao): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val user = User(type = userType, document =  userDoc)
            return UserViewModel(user, userDatabaseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}