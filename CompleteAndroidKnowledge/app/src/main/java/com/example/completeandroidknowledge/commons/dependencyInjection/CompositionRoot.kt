package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import com.example.completeandroidknowledge.commons.Constants
import com.example.completeandroidknowledge.section1.model.UserDatabase
import com.example.completeandroidknowledge.section1.network.sesionServices.SesionAPI
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class CompositionRoot {
    private var retrofit: Retrofit? = null
        get() {
            if(field == null){
                field = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            }
            return field
        }


    fun getUserDatabaseInstance(application: Application): UserDatabase = UserDatabase.getInstance(application)
    fun getLoginAPI() : SesionAPI = retrofit!!.create(SesionAPI::class.java)

}