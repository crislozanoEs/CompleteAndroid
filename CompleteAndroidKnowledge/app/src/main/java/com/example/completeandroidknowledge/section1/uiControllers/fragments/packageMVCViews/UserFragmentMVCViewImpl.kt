package com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.UserViewModel

class UserFragmentMVCViewImpl(layoutInflater: LayoutInflater, parent: ViewGroup?): UserFragmentMVCView,
    ObservableViewMVCImpl<UserFragmentMVCView.Listener, UserFragmentBinding>() {

    override var binding: UserFragmentBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.user_fragment, parent,false)

    init {
        binding.loginButton.setOnClickListener{ notifyListener() }
        setRootView(binding.root)
    }

    private fun notifyListener(){
        getListener().forEach {
            it.transferToMainActivity()
        }
    }

    override fun getPassword(): String = binding.passwordEdit.text.toString()

    override fun setViewModel(viewModel: UserViewModel) {
        binding.userViewModel = viewModel
    }

    override fun setLifeCycleOwnerView(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }
}