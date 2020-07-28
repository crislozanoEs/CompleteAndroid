package com.example.completeandroidknowledge.commons.navigation

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl.LoginFragmentPublicDirections
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl.ProductsInfoFragmentPublicDirections

class Navigation {

    fun fromLoginFragmentToUserFragment(userType: String, userDoc: String, view : View) {
        view.findNavController ().navigate(LoginFragmentPublicDirections.actionLoginFragmentToUserFragment(userType, userDoc))
    }
}