package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.views.ViewMVCFactory
import com.example.completeandroidknowledge.network.productsServices.ProductAPI
import com.example.completeandroidknowledge.network.productsServices.ProductSummaryServiceUseCase
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabaseUseCaseImpl
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

class ControllerCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot?) {

    fun getActivity(): AppCompatActivity = activityCompositionRoot!!.getActivity()

    fun getContext(): Context = activityCompositionRoot!!.getActivity().baseContext

    private fun getSessionAPI(): SessionAPI = activityCompositionRoot!!.getSessionAPI()

    private fun getProductAPI(): ProductAPI = activityCompositionRoot!!.getProductAPI()

    private fun getLayoutInflater(): LayoutInflater = LayoutInflater.from(getContext())

    private fun getFragmentManager(): FragmentManager = getActivity().supportFragmentManager

    private fun getUserDatabaseInstance(application: Application) = activityCompositionRoot!!.getUserDatabaseInstance(application)

    private fun getProductSummaryDatabaseInstance(application: Application) = activityCompositionRoot!!.getProductSummaryInstance(application)

    fun getViewMVCFactory(): ViewMVCFactory = ViewMVCFactory(getLayoutInflater())

    fun getLoginServicesUseCase(): SessionServicesUseCase = SessionServicesUseCase(getSessionAPI())

    fun getProductServiceUseCase(): ProductSummaryServiceUseCase = ProductSummaryServiceUseCase(getProductAPI())

    fun getDialogManager(): DialogManager = DialogManager(getContext(), getFragmentManager())

    fun getDialogEventBus(): DialogEventBus = activityCompositionRoot!!.getDialogEventBus()

    fun getUserDatabaseUseCase(application: Application): UserDatabaseUseCaseImpl = UserDatabaseUseCaseImpl(getUserDatabaseInstance(application).userDatabaseDao)

    fun getNavigation(): Navigation = Navigation()

    fun getProductSummaryUseCaseImpl(application: Application) =  ProductSummaryDatabaseUseCaseImpl(getProductSummaryDatabaseInstance(application).productSummaryDatabaseDao)

}


