package com.example.completeandroidknowledge.network.sessionServices

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface SessionAPI {
    @GET("session/login/")
    fun loginAsync() : Deferred<UserNetwork>
}