package com.example.completeandroidknowledge.section1.network.sesionServices

import com.example.completeandroidknowledge.section1.network.UserNetwork
import kotlinx.coroutines.Deferred
import retrofit2.http.POST

interface SesionAPI {
    @POST("session/login")
    fun login() : Deferred<UserNetwork>
}