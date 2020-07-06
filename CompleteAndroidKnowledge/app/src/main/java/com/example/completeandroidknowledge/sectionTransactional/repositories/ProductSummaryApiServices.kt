package com.example.completeandroidknowledge.sectionTransactional.repositories

import retrofit2.Call
import retrofit2.http.GET


interface MarsApiService {
    @GET("productSummary")
    fun getProperties():
            Call<String>
}

