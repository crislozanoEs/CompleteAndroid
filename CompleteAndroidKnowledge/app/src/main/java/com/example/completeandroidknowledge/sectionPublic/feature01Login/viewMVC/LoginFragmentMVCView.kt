package com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel.LoginViewModel

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
    fun initDocumentsSpinner(documents: List<String>, context: Context)
    fun startValidator()
}