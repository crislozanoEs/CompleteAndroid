package com.example.completeandroidknowledge.repository.userDatabase

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.publicSection.model.User
import com.example.completeandroidknowledge.publicSection.model.asDatabaseObject
import kotlinx.coroutines.*

class UserDatabaseUseCaseImpl(private val userDatabaseDao: UserDatabaseDao): BaseObservable<UserDatabaseUseCaseImpl.Listener>(), UserDatabaseUseCase {

    interface Listener{
        fun onUserRetrieved(user: User?)
        fun onUserUpdated()
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)
    fun getJobObject() = job

    // Interface exposes methods
    override fun initGetUserFromDatabase(){
        uiScope.launch {
            val userTable = getUserFromDatabase()
            if(userTable != null){
                val user = userTable.asDomainObject()
                notifyUserRetrieved(user)
            }
        }
    }
    override fun initSaveUserInDatabase(document: String, type: String){
        uiScope.launch {
            // It can be improve although it works.
            val user =
                UserTable(
                    document = document,
                    type =  type
                )
            saveUserInDatabase(user)
        }
    }
    override fun initUpdateUser(user: User?){
        uiScope.launch {
            if(user == null)
                return@launch
            else
                updateUserInDatabase(user)
            notifyUserUpdated()

        }
    }

    // Suspend functions
    private suspend fun saveUserInDatabase(userTable: UserTable){
        withContext(Dispatchers.IO){
            userDatabaseDao.clearUser()
            userDatabaseDao.insert(userTable)
        }
    }
    private suspend fun updateUserInDatabase(user: User){
        withContext(Dispatchers.IO){
            userDatabaseDao.update(user.asDatabaseObject())
        }
    }
    private suspend fun getUserFromDatabase(): UserTable?{
        return withContext(Dispatchers.IO){
            userDatabaseDao.get().value
        }
    }

    // Notifiers
    private fun notifyUserRetrieved(user: User){
        getListeners().forEach{
            it.onUserRetrieved(user)
        }
    }
    private fun notifyUserUpdated() {
        getListeners().forEach {
            it.onUserUpdated()
        }
    }

}