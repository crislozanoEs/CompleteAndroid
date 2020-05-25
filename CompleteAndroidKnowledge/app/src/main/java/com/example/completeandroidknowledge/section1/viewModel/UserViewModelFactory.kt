package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.section1.model.User

class UserViewModelFactory (private val userType: String, private val userDoc: String): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val user: User = User(userType, userDoc)
            return UserViewModel(user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}