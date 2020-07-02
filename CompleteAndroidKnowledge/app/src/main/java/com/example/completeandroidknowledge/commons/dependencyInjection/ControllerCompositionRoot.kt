package com.example.completeandroidknowledge.commons.dependencyInjection

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.views.ViewMVCFactory
import com.example.completeandroidknowledge.network.sessionServices.SessionAPI
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

class ControllerCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot?) {

    private fun getActivity(): AppCompatActivity = activityCompositionRoot!!.getActivity()

    private fun getContext(): Context = activityCompositionRoot!!.getActivity().baseContext

    private fun getSessionAPI(): SessionAPI = activityCompositionRoot!!.getSessionAPI()

    private fun getLayoutInflater(): LayoutInflater = LayoutInflater.from(getContext())

    private fun getFragmentManager(): FragmentManager = getActivity().supportFragmentManager

    fun getUserDatabaseInstance(application: Application) = activityCompositionRoot!!.getUserDatabaseInstance(application)

    fun getViewMVCFactory(): ViewMVCFactory = ViewMVCFactory(getLayoutInflater())

    fun getLoginServicesUseCase(): SessionServicesUseCase = SessionServicesUseCase(getSessionAPI())

    fun getDialogManager(): DialogManager = DialogManager(getContext(), getFragmentManager())

    fun getDialogEventBus(): DialogEventBus = DialogEventBus()

    fun getUserDatabaseUseCase(application: Application): UserDatabaseUseCaseImpl = UserDatabaseUseCaseImpl(getUserDatabaseInstance(application).userDatabaseDao)

}