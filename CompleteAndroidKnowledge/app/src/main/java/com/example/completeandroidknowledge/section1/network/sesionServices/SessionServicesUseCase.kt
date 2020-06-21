package com.example.completeandroidknowledge.section1.network.sesionServices

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.network.UserNetwork
import com.example.completeandroidknowledge.section1.network.asDomainObject
import kotlinx.coroutines.*

class SessionServicesUseCase(private val sessionAPI: SesionAPI): BaseObservable<SessionServicesUseCase.Listener>() {

    interface Listener{
        fun loginSucceed(user : User)
        fun loginFailed()
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)


    fun getJobObject() = job

    fun executeLogin(){
        uiScope.launch {
            doLogin()
        }
    }
    private suspend fun doLogin(){
        withContext(Dispatchers.IO){
            val userDeferred = sessionAPI.login()
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
        getListeners().forEach {
            it.loginSucceed(userDomain)
        }
    }

    private fun notifyLoginFailed(){
        getListeners().forEach {
            it.loginFailed()
        }
    }

}