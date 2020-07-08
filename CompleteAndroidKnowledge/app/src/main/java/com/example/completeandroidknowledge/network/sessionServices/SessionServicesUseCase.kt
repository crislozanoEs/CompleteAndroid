package com.example.completeandroidknowledge.network.sessionServices

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.sectionPublic.model.User
import kotlinx.coroutines.*

class SessionServicesUseCase(private val sessionAPI: SessionAPI):
    BaseObservable<SessionServicesUseCase.Listener>() {

    interface Listener{
        fun loginSucceed(user : User)
        fun loginFailed()
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)


    fun getJobObject() = job

    fun executeLogin(){
        uiScope.launch {
            callLoginService()
        }
    }
    private suspend fun callLoginService(){
        withContext(Dispatchers.IO){
            val userDeferred = sessionAPI.loginAsync()
            try{
                val user = userDeferred.await()
                notifyLoginSucceed(user)
            }catch (e: Exception){
                notifyLoginFailed()
            }
        }
    }

    private fun notifyLoginSucceed(user: UserNetwork){
        val userDomain = user.asDomainObject()
        this.getListeners().forEach {
            it.loginSucceed(userDomain)
        }
    }

    private fun notifyLoginFailed(){
        getListeners().forEach {
            it.loginFailed()
        }
    }

}