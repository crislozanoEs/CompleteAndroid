package com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory (private val userDatabaseUseCaseImpl: UserDatabaseUseCaseImpl, private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                userDatabaseUseCaseImpl,
                application
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}