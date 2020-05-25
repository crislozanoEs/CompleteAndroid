package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    //private var user: User = User("Usuario", "", "")
    private var _userType = MutableLiveData<String>()
    val userType: LiveData<String>
        get() = _userType

    private var _userDoc = MutableLiveData<String>()
    val userDoc: LiveData<String>
        get() = _userDoc


    init{
        _userDoc.value = ""
        _userType.value = "Usuario"
    }

    fun alterUser(typeDocument: String , document: String){
        _userDoc.value = "user_R$document"
        _userType.value = typeDocument
    }
}