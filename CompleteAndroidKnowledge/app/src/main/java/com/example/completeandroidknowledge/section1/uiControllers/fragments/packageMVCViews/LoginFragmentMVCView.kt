package com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModel

interface LoginFragmentMVCView :
    ObservableViewMVC<LoginFragmentMVCView.Listener, LoginFragmentBinding> {

    interface Listener{
        fun onNextButtonClick()
    }
    var binding: LoginFragmentBinding
    fun setViewModel(viewModel: LoginViewModel)
    fun getTypeDocument(): String
    fun getDocument(): String
    fun setLifeCycleOwnerView(owner: LifecycleOwner)
}