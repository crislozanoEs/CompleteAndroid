package com.example.completeandroidknowledge.commons.navigation

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.section1.uiControllers.fragments.LoginFragmentDirections
import com.example.completeandroidknowledge.section2.uiControllers.MainActivity

class Navigation {

    fun fromLoginFragmentToUserFragment(userType: String, userDoc: String, view : View) {
        view.findNavController ().navigate(LoginFragmentDirections.actionLoginFragmentToUserFragment(userType, userDoc))
    }

    fun fromPublicActivityToMainActivity(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}