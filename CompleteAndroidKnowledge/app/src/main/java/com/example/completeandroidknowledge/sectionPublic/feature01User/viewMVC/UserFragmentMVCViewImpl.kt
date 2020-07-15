package com.example.completeandroidknowledge.sectionPublic.feature01User.viewMVC

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature01User.validator.UserValidator
import com.example.completeandroidknowledge.sectionPublic.feature01User.viewModel.UserViewModel

class UserFragmentMVCViewImpl(layoutInflater: LayoutInflater, parent: ViewGroup?): UserFragmentMVCView,
    ObservableViewMVCImpl<UserFragmentMVCView.Listener, UserFragmentBinding>() {

    override var binding: UserFragmentBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.user_fragment, parent,false)

    private lateinit var userValidator: UserValidator
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

    override fun clearPassword() {
        binding.passwordEdit.text.clear()
    }
    override fun setLoadingVisibility(enable: Boolean) {
        if(enable)
            binding.loadingProgress.visibility = View.VISIBLE
        else
            binding.loadingProgress.visibility = View.GONE

    }

    override fun startValidator() {
        userValidator = UserValidator(binding)
        binding.validator = userValidator
    }
}