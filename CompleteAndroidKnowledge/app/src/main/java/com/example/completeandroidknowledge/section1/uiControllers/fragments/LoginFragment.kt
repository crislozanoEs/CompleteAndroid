package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.section1.model.UserDatabase
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.LoginFragmentMVCView
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.LoginFragmentMVCViewImpl
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModel
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModelFactory

class LoginFragment : Fragment(), LoginFragmentMVCView.Listener{
    private lateinit var loginFragmentMVCView: LoginFragmentMVCView
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentMVCView = LoginFragmentMVCViewImpl(inflater,container)
        // binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        // binding.user = user
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao
        viewModelFactory = LoginViewModelFactory(dataSource, application)
        // viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        loginFragmentMVCView.setViewModel(viewModel)
        loginFragmentMVCView.setLifeCycleOwnerView(this)
        loginFragmentMVCView.registerListener(this)
        return loginFragmentMVCView.getRootView()
    }

    private fun transferToUserPage(){
        this.viewModel.alterUser(loginFragmentMVCView.getTypeDocument(), loginFragmentMVCView.getDocument())
        val userType = viewModel.userType.value ?: ""
        val userDoc = viewModel.userDoc.value ?: ""
        this.viewModel.saveUser()
        loginFragmentMVCView.getRootView().findNavController ().navigate(LoginFragmentDirections.actionLoginFragmentToUserFragment(userType, userDoc))
    }

    override fun onNextButtonClick() {
        transferToUserPage()
    }
}
