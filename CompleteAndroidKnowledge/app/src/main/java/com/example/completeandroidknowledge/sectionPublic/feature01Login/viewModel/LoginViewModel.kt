package com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.commons.Constants
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl
import com.example.completeandroidknowledge.sectionPublic.model.User

class LoginViewModel(private val userDatabaseUseCaseImpl: UserDatabaseUseCaseImpl, application: Application): ViewModel(), UserDatabaseUseCaseImpl.Listener {

    private val _documentTypes= MutableLiveData<MutableList<String>>()
    val documentType: LiveData<MutableList<String>>
        get() = _documentTypes

    private var _userType = MutableLiveData<String>()
    val userType: LiveData<String>
        get() = _userType

    private var _userDoc = MutableLiveData<String>()
    val userDoc: LiveData<String>
        get() = _userDoc


    init{

        _documentTypes.value = mutableListOf<String>()
        _userType.value = "Usuario"
        userDatabaseUseCaseImpl.registerListener(this)
        userDatabaseUseCaseImpl.initGetUserFromDatabase()

    }

    fun executeCallDocumentsTypes(){
        Constants.documentType1.forEach{
            _documentTypes.value!!.add(it.value)
        }
    }
    fun saveUser(){
        userDatabaseUseCaseImpl.initSaveUserInDatabase(_userDoc.value!!, _userType.value!!)
    }

    fun alterUser(typeDocument: String , document: String){
        _userDoc.value = "user_R$document"
        _userType.value = typeDocument
    }

    override fun onCleared() {
        super.onCleared()
        userDatabaseUseCaseImpl.unregisterListener(this)
        userDatabaseUseCaseImpl.getJobObject().cancel()
    }

    override fun onUserRetrieved(user: User?) {
        user?.let {
            _userDoc.value = it.userDocument
            _userType.value = it.userType
        }
    }

    override fun onUserUpdated() {
        //This method is not used in this fragment
    }
}