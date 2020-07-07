package com.example.completeandroidknowledge.commons.navigation

import android.view.View
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl.LoginFragmentPublicDirections

class Navigation {

    fun fromLoginFragmentToUserFragment(userType: String, userDoc: String, view : View) {
        view.findNavController ().navigate(LoginFragmentPublicDirections.actionLoginFragmentToUserFragment(userType, userDoc))
    }


}