package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.*
import com.example.completeandroidknowledge.section1.network.sesionServices.SessionServicesUseCase
import kotlinx.coroutines.*

class UserViewModel(user: User,
                    private val userDatabaseDao: UserDatabaseDao,
                    private val sessionServicesUseCase: SessionServicesUseCase):
    ViewModel(),
    SessionServicesUseCase.Listener{
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

    private fun updateUser(){
        uiScope.launch {
            if(user.value == null)
                return@launch
            else
                updateUserInDatabase()
            _navigationToMainFlag.value = true

        }
    }

    private suspend fun updateUserInDatabase(){
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
        actualState = STATES.LOGIN_SUCCEED
        _user.value = user
        updateUser()
    }

    override fun loginFailed() {
        actualState = STATES.LOGIN_FAIL
        TODO("Not yet implemented")
    }

    fun executeLoginService() {
        actualState = STATES.LOADING
        sessionServicesUseCase.executeLogin()
    }
}