package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import com.example.completeandroidknowledge.commons.Constants
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.network.productsServices.ProductAPI
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabase
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CompositionRoot(var application: Application) {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private var retrofit: Retrofit? = null
        get() {
            if(field == null){
                field = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .baseUrl(Constants.BASE_URL)
                    .build()
            }
            return field
        }

    private var dialogEventBus: DialogEventBus? = null
    fun getDialogEventBus(): DialogEventBus{
        if(dialogEventBus == null){
            dialogEventBus = DialogEventBus()
        }
        return dialogEventBus!!
    }

    // DatabaseInstance
    fun getUserDatabaseInstance(): UserDatabase = UserDatabase.getInstance(application)
    fun getProductSummaryDatabaseInstance(): ProductSummaryDatabase = ProductSummaryDatabase.getInstance(application)

    // API
    fun getLoginAPI() : SessionAPI = retrofit!!.create(SessionAPI::class.java)
    fun getProductAPI(): ProductAPI = retrofit!!.create(ProductAPI::class.java)



}