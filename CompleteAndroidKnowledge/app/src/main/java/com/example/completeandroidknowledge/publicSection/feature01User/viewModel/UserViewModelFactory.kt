package com.example.completeandroidknowledge.publicSection.feature01User.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.publicSection.model.User
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

class UserViewModelFactory (private val userType: String,
                            private val userDoc: String,
                            private val userDatabaseUseCaseImpl: UserDatabaseUseCaseImpl,
                            private val sessionServicesUseCase: SessionServicesUseCase,
                            private val dialogManager: DialogManager,
                            private val dialogEventBus: DialogEventBus):
    ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val user = User(userType = userType, userDocument =  userDoc)
            return UserViewModel(
                user,
                userDatabaseUseCaseImpl,
                sessionServicesUseCase,
                dialogManager,
                dialogEventBus
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}