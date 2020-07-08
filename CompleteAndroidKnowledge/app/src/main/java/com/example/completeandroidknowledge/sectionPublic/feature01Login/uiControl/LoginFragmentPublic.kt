package com.example.completeandroidknowledge.sectionPublic.feature01Login.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC.LoginFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel.LoginViewModel
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel.LoginViewModelFactory

class LoginFragmentPublic : BaseFragmentPublic(), LoginFragmentMVCView.Listener{
    private lateinit var loginFragmentMVCView: LoginFragmentMVCView
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory
    private lateinit var navigation: Navigation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getLoginFragmentMVCView(container)
        navigation = getCompositionRootObject().getNavigation()
        val application = requireNotNull(this.activity).application
        this.viewModelFactory =
            LoginViewModelFactory(
                getCompositionRootObject().getUserDatabaseUseCase(application),
                application
            )
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        this.loginFragmentMVCView.setViewModel(this.viewModel)
        this.loginFragmentMVCView.setLifeCycleOwnerView(this)
        return loginFragmentMVCView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        this.loginFragmentMVCView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        this.loginFragmentMVCView.unregisterListener(this)
    }

    private fun transferToUserPage(){
        this.viewModel.alterUser(loginFragmentMVCView.getTypeDocument(), loginFragmentMVCView.getDocument())
        val userType = viewModel.userType.value ?: ""
        val userDoc = viewModel.userDoc.value ?: ""
        this.viewModel.saveUser()
        navigation.fromLoginFragmentToUserFragment(userType, userDoc, loginFragmentMVCView.getRootView())
    }

    override fun onNextButtonClick() {
        transferToUserPage()
    }
}
