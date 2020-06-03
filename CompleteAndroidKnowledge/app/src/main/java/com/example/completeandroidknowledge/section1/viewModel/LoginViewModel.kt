package com.example.completeandroidknowledge.section1.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.model.UserDatabaseDao
import kotlinx.coroutines.*

class LoginViewModel(val userDatabaseDao: UserDatabaseDao, application: Application): ViewModel() {

    //private var user: User = User("Usuario", "", "")
    private var _userType = MutableLiveData<String>()
    // Coroutines
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)


    val userType: LiveData<String>
        get() = _userType

    private var _userDoc = MutableLiveData<String>()
    val userDoc: LiveData<String>
        get() = _userDoc


    init{
        _userType.value = "Usuario"
        initUser()
    }

    private fun initUser(){
        uiScope.launch {
            val user = getUserFromDatabase()
            if(user != null){
                _userType.value = user.type
                _userDoc.value = user.document
            }
        }
    }

    private suspend fun getUserFromDatabase(): User?{
        return withContext(Dispatchers.IO){
            val user = userDatabaseDao.get().value
            user
        }
    }

    fun saveUser(){
        uiScope.launch {
            var user = User(document = _userDoc.value!!, type = _userType.value!!)
            saveUserInDatabase(user)
        }
    }

    private suspend fun saveUserInDatabase(user: User){
        withContext(Dispatchers.IO){
            userDatabaseDao.clearUser()
            userDatabaseDao.insert(user)
        }
    }

    fun alterUser(typeDocument: String , document: String){
        _userDoc.value = "user_R$document"
        _userType.value = typeDocument
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}