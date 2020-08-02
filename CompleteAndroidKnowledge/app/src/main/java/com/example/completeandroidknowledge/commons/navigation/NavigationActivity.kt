package com.example.completeandroidknowledge.commons.navigation

import androidx.navigation.NavController
import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl.LoginFragmentPublicDirections
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl.ProductsInfoFragmentPublicDirections
import com.example.completeandroidknowledge.sectionPublic.feature21News.uiControl.NewsFragmentPublicDirections

class NavigationActivity(private var navController: NavController): BaseObservable<NavigationActivity.Listener>() {

    interface Listener{
        fun onHomeClicked()
        fun onProductsInfoClicked()
        fun onNewsClicked()
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

    fun updateOnNewsClicked(){
        getListeners().forEach {
            it.onNewsClicked()
        }
    }

    fun fromHomeToProductsInfo() = navController.navigate(LoginFragmentPublicDirections.actionLoginFragmentToProductsInfoFragmentPublic())
    fun fromHomeToNews() = navController.navigate(LoginFragmentPublicDirections.actionLoginFragmentToNewsFragmentPublic())

    fun fromProductsIntoToHome() = navController.navigate(ProductsInfoFragmentPublicDirections.actionProductsInfoFragmentPublicToLoginFragment())
    fun fromProductsInfoToNews() = navController.navigate(ProductsInfoFragmentPublicDirections.actionProductsInfoFragmentPublicToNewsFragmentPublic())

    fun fromNewsToHome() = navController.navigate(NewsFragmentPublicDirections.actionNewsFragmentPublicToLoginFragment())
    fun fromNewsToProductsInfo() = navController.navigate(NewsFragmentPublicDirections.actionNewsFragmentPublicToProductsInfoFragmentPublic())
}