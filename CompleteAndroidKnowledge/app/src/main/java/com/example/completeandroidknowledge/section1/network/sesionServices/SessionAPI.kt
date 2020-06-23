package com.example.completeandroidknowledge.section1.network.sesionServices

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST

interface SessionAPI {
    @GET("session/login/")
    fun loginAsync() : Deferred<UserNetwork>
}