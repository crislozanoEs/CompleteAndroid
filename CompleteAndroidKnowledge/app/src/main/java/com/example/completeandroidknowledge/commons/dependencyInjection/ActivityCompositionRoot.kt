package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.network.productsServices.ProductAPI
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabase
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabase

class ActivityCompositionRoot(private val compositionRoot: CompositionRoot, private val activity: AppCompatActivity) {

    fun getSessionAPI(): SessionAPI = compositionRoot.getLoginAPI()
    fun getProductAPI(): ProductAPI = compositionRoot.getProductAPI()
    fun getActivity(): AppCompatActivity = activity
    fun getUserDatabaseInstance(application: Application): UserDatabase = compositionRoot.getUserDatabaseInstance(application)
    fun getProductSummaryInstance(application: Application): ProductSummaryDatabase = compositionRoot.getProductSummaryDatabaseInstance(application)
    fun getDialogEventBus(): DialogEventBus = compositionRoot.getDialogEventBus()
}