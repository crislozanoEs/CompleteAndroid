package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.commons.views.ViewMVCFactory
import com.example.completeandroidknowledge.network.productsServices.ProductAPI
import com.example.completeandroidknowledge.network.productsServices.ProductSummaryServiceUseCase
import com.example.completeandroidknowledge.network.publicServices.PublicAPI
import com.example.completeandroidknowledge.network.publicServices.productsInfoServices.ProductsInfoUseCase
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabaseUseCaseImpl
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

class ControllerCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot?) {

    fun getActivity(): AppCompatActivity = activityCompositionRoot!!.getActivity()

    fun getContext(): Context = activityCompositionRoot!!.getActivity().baseContext

    private fun getSessionAPI(): SessionAPI = activityCompositionRoot!!.getSessionAPI()

    private fun getProductAPI(): ProductAPI = activityCompositionRoot!!.getProductAPI()

    private fun getPublicAPI(): PublicAPI = activityCompositionRoot!!.getPublicAPI()

    private fun getLayoutInflater(): LayoutInflater = LayoutInflater.from(getContext())

    private fun getFragmentManager(): FragmentManager = getActivity().supportFragmentManager

    private fun getUserDatabaseInstance() = activityCompositionRoot!!.getUserDatabaseInstance()

    private fun getProductSummaryDatabaseInstance() = activityCompositionRoot!!.getProductSummaryInstance()

    fun getViewMVCFactory(): ViewMVCFactory = ViewMVCFactory(getLayoutInflater())

    fun getLoginServicesUseCase(): SessionServicesUseCase = SessionServicesUseCase(getSessionAPI())

    fun getProductServiceUseCase(): ProductSummaryServiceUseCase = ProductSummaryServiceUseCase(getProductAPI())

    fun getProductsInfoUseCase(): ProductsInfoUseCase = ProductsInfoUseCase(getPublicAPI())

    fun getDialogManager(): DialogManager = DialogManager(getContext(), getFragmentManager())

    fun getDialogEventBus(): DialogEventBus = activityCompositionRoot!!.getDialogEventBus()

    fun getUserDatabaseUseCase(): UserDatabaseUseCaseImpl = UserDatabaseUseCaseImpl(getUserDatabaseInstance().userDatabaseDao)

    fun getNavigation(): Navigation = Navigation()

    fun getMainNavigation(): NavigationActivity = activityCompositionRoot!!.getNavigationActivity()

    fun getProductSummaryUseCaseImpl():ProductSummaryDatabaseUseCaseImpl =  ProductSummaryDatabaseUseCaseImpl(getProductSummaryDatabaseInstance().productSummaryDatabaseDao)

}


