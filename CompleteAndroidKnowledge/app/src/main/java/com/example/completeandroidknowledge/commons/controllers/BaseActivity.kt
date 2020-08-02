package com.example.completeandroidknowledge.commons.controllers

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.completeandroidknowledge.commons.CustomApplication
import com.example.completeandroidknowledge.commons.dependencyInjection.ActivityCompositionRoot
import com.example.completeandroidknowledge.commons.dependencyInjection.CompositionRoot
import com.example.completeandroidknowledge.commons.dependencyInjection.ControllerCompositionRoot

open class BaseActivity: AppCompatActivity() {

    private var navController: NavController?= null

     var activityCompositionRoot: ActivityCompositionRoot? = null
         private set
         get(){
            if(field == null){
                val application = application as CustomApplication
                field = ActivityCompositionRoot(application.getCompositionRoot(), this)
            }
            return field
        }

    fun setNavController(navController: NavController){
        this.navController = navController
        activityCompositionRoot!!.navController = navController
        activityCompositionRoot!!.createNavigationActivity()
    }

}