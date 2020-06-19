package com.example.completeandroidknowledge.section2.repositories

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


interface MarsApiService {
    @GET("productSummary")
    fun getProperties():
            Call<String>
}

