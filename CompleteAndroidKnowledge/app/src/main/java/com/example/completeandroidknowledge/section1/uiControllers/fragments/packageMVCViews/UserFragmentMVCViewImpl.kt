package com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.section1.uiControllers.PublicActivity
import com.example.completeandroidknowledge.section1.viewModel.UserViewModel

class UserFragmentMVCViewImpl(layoutInflater: LayoutInflater, parent: ViewGroup?, val activity: PublicActivity): UserFragmentMVCView,
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

    override fun clearPassword() {
        binding.passwordEdit.text.clear()
    }
    override fun setLoadingVisibility(enable: Boolean) {
        if(enable){
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            binding.loadingProgress.visibility = View.VISIBLE
        }else{
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            binding.loadingProgress.visibility = View.GONE
        }
    }
}