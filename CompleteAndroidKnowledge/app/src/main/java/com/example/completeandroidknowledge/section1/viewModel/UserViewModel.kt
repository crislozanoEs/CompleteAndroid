package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.*
import kotlinx.coroutines.*

class UserViewModel(user: User, val userDatabaseDao: UserDatabaseDao): ViewModel(){

    //private var user: User = User("Usuario", "", "")
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _navigationToMainFlag = MutableLiveData<Boolean>()
    val navigationToMainFlag: LiveData<Boolean>
        get() = _navigationToMainFlag

    private var _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    init{
        _user.value = user
    }

    fun doneNavigation(){
        _navigationToMainFlag.value = false
    }

    fun updatePasswordUser(){
        uiScope.launch {
            if(user.value!!.password == "")
                return@launch
            else
                setPasswordInDatabase()
            _navigationToMainFlag.value = true

        }
    }

    private suspend fun setPasswordInDatabase(){
        withContext(Dispatchers.IO){
            userDatabaseDao.update(_user.value!!.asDatabaseObject())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}