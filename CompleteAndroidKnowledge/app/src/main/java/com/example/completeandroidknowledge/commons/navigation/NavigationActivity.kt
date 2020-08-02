package com.example.completeandroidknowledge.commons.navigation

import androidx.navigation.NavController
import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl.LoginFragmentPublicDirections
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl.ProductsInfoFragmentPublicDirections

class NavigationActivity(private var navController: NavController): BaseObservable<NavigationActivity.Listener>() {

    interface Listener{
        fun onHomeClicked()
        fun onProductsInfoClicked()
    }
    fun updateOnHomeClicked() {
        getListeners().forEach {
            it.onHomeClicked()
        }
    }

    fun updateOnProductsInfoClicked(){
        getListeners().forEach {
            it.onProductsInfoClicked()
        }
    }

    fun fromHomeToProductsInfo() = navController.navigate(LoginFragmentPublicDirections.actionLoginFragmentToProductsInfoFragmentPublic())
    fun fromProductsIntoToHome() = navController.navigate(ProductsInfoFragmentPublicDirections.actionProductsInfoFragmentPublicToLoginFragment())
}