package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.completeandroidknowledge.section1.network.sesionServices.SesionAPI

class ControllerCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot?) {

    private fun getActivity(): AppCompatActivity = activityCompositionRoot!!.getActivity()

    private fun getContext(): Context = activityCompositionRoot!!.getActivity().baseContext

    private fun getSesionAPI(): SesionAPI = activityCompositionRoot!!.getSessionAPI()

    private fun getLayoutInflater(): LayoutInflater = LayoutInflater.from(getContext())

    fun getUserDatabaseInstance(application: Application) = activityCompositionRoot!!.getUserDatabaseInstance(application)

}