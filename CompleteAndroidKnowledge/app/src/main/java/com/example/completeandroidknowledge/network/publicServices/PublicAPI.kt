package com.example.completeandroidknowledge.network.publicServices

import com.example.completeandroidknowledge.network.publicServices.productsInfoServices.ProductsInfoNetwork
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PublicAPI {

    @GET("/public/productsInfoP")
    fun getProductsInfoAsync(): Deferred<List<ProductsInfoNetwork>>
}