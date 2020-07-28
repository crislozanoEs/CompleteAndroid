package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.network.productsServices.ProductAPI
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabase
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabase
import com.example.completeandroidknowledge.sectionPublic.PublicActivity
import com.example.completeandroidknowledge.sectionPublic.PublicActivityMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.feature01Login.validator.LoginValidator

class ActivityCompositionRoot(private val compositionRoot: CompositionRoot, private val activity: AppCompatActivity) {

    fun getSessionAPI(): SessionAPI = compositionRoot.getLoginAPI()
    fun getProductAPI(): ProductAPI = compositionRoot.getProductAPI()
    fun getActivity(): AppCompatActivity = activity
    fun getUserDatabaseInstance(): UserDatabase = compositionRoot.getUserDatabaseInstance()
    fun getProductSummaryInstance(): ProductSummaryDatabase = compositionRoot.getProductSummaryDatabaseInstance()
    fun getDialogEventBus(): DialogEventBus = compositionRoot.getDialogEventBus()
    fun getNavigationActivity(navController: NavController): NavigationActivity = NavigationActivity(navController)
    fun getActivityMVCView(publicActivity: PublicActivity): PublicActivityMVCViewImpl = PublicActivityMVCViewImpl(publicActivity)
}