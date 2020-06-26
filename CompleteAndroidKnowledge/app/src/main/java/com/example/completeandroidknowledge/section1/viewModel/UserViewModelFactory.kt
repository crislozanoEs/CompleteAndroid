package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.model.UserDatabaseDao
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase

class UserViewModelFactory (private val userType: String, private val userDoc: String, private val userDatabaseDao: UserDatabaseDao, private val sessionServicesUseCase: SessionServicesUseCase): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val user = User(userType = userType, userDocument =  userDoc)
            return UserViewModel(user, userDatabaseDao, sessionServicesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}