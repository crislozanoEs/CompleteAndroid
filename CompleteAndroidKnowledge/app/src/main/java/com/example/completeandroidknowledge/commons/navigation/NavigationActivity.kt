package com.example.completeandroidknowledge.commons.navigation

import androidx.navigation.NavController
import com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl.LoginFragmentPublicDirections
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl.ProductsInfoFragmentPublicDirections

class NavigationActivity(private var navController: NavController) {
    fun fromLoginFragmentToProductsInfo(){
        navController.navigate(LoginFragmentPublicDirections.actionLoginFragmentToProductsInfoFragmentPublic())
    }

    fun fromProductsInfoToLoginFragment(){
        navController.navigate(ProductsInfoFragmentPublicDirections.actionProductsInfoFragmentPublicToLoginFragment())
    }
}