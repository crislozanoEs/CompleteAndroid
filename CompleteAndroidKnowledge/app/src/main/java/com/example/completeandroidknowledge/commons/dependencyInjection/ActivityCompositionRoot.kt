package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.completeandroidknowledge.section1.model.UserDatabase
import com.example.completeandroidknowledge.section1.network.sesionServices.SesionAPI

class ActivityCompositionRoot(private val compositionRoot: CompositionRoot, private val activity: AppCompatActivity) {

    fun getSessionAPI(): SesionAPI = compositionRoot.getLoginAPI()
    fun getActivity(): AppCompatActivity = activity
    fun getUserDatabaseInstance(application: Application): UserDatabase = compositionRoot.getUserDatabaseInstance(application)
}