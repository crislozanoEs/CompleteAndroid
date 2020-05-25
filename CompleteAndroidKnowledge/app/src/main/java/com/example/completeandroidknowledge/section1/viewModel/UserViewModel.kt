package com.example.completeandroidknowledge.section1.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.User

class UserViewModel(user: User): ViewModel(){

    //private var user: User = User("Usuario", "", "")
    private var _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    init{
        _user.value = user
    }

}