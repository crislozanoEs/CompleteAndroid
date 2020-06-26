package com.example.completeandroidknowledge.network.productsServices

import com.example.completeandroidknowledge.network.sessionServices.UserNetwork
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ProductAPI {
    @GET("product/summary/")
    fun getProductSummary() : Deferred<UserNetwork>
}