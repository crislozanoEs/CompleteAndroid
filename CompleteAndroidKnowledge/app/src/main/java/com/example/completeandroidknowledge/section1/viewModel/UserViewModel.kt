package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.*
import com.example.completeandroidknowledge.section1.network.sesionServices.SessionServicesUseCase
import kotlinx.coroutines.*

class UserViewModel(user: User, private val userDatabaseDao: UserDatabaseDao, private val sessionServicesUseCase: SessionServicesUseCase): ViewModel(),  SessionServicesUseCase.Listener{

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var actualState: STATES = STATES.IDLE

    enum class STATES{
        IDLE, LOADING, LOGIN_SUCCEED, LOGIN_FAIL
    }

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

    fun updateUser(){
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
        sessionServicesUseCase.getJobObject().cancel()
    }

    override fun loginSucceed(user: User) {
        //_user.value.
        //updateUser()
    }

    override fun loginFailed() {
        TODO("Not yet implemented")
    }

    fun executeLoginService() {
        actualState = STATES.LOADING
        sessionServicesUseCase.executeLogin()
    }
}