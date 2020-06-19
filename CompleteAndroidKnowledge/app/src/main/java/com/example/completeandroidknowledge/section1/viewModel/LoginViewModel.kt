package com.example.completeandroidknowledge.section1.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.model.UserTable
import com.example.completeandroidknowledge.section1.model.UserDatabaseDao
import com.example.completeandroidknowledge.section1.model.asDomainObject
import kotlinx.coroutines.*

class LoginViewModel(private val userDatabaseDao: UserDatabaseDao, application: Application): ViewModel() {

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
            val userTable = getUserFromDatabase()
            if(userTable != null){
                val user = userTable.asDomainObject()
                _userType.value = user.userType
                _userDoc.value = user.userDocument
            }
        }
    }

    private suspend fun getUserFromDatabase(): UserTable?{
        return withContext(Dispatchers.IO){
            userDatabaseDao.get().value
        }
    }

    fun saveUser(){
        uiScope.launch {
            // It can be improve although it works.
            var user = UserTable(document = _userDoc.value!!, type = _userType.value!!)
            saveUserInDatabase(user)
        }
    }

    private suspend fun saveUserInDatabase(userTable: UserTable){
        withContext(Dispatchers.IO){
            userDatabaseDao.clearUser()
            userDatabaseDao.insert(userTable)
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