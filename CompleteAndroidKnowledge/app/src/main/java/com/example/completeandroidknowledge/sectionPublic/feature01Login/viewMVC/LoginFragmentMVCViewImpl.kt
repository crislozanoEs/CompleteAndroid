package com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel.LoginViewModel

class LoginFragmentMVCViewImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    LoginFragmentMVCView, ObservableViewMVCImpl<LoginFragmentMVCView.Listener, LoginFragmentBinding>() {

    override var binding: LoginFragmentBinding =
        DataBindingUtil.inflate(inflater, R.layout.login_fragment, parent, false)

    init{
        binding.nextUserButton.setOnClickListener{ notifyListeners() }
        setRootView(binding.root)
    }


    private fun notifyListeners(){
        getListener().forEach {
            it.onNextButtonClick()
        }
    }
    override fun getRootView(): View = binding.root

    override fun setViewModel(viewModel: LoginViewModel){
        binding.loginViewModel = viewModel
    }
    override fun getTypeDocument(): String = binding.typeDocEdit.text.toString()

    override fun getDocument(): String = binding.textDocEdit.text.toString()

    override fun setLifeCycleOwnerView(owner: LifecycleOwner) {
        setLifecycleOwner(binding, owner)
    }

}