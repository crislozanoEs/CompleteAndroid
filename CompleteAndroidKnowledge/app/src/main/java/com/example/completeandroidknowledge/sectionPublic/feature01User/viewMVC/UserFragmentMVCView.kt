package com.example.completeandroidknowledge.sectionPublic.feature01User.viewMVC

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature01User.viewModel.UserViewModel

interface UserFragmentMVCView :
    ObservableViewMVC<UserFragmentMVCView.Listener, UserFragmentBinding> {

    interface Listener{
        fun transferToMainActivity()
    }
    var binding: UserFragmentBinding
    fun getPassword(): String
    fun setViewModel(viewModel: UserViewModel)
    fun setLifeCycleOwnerView(owner: LifecycleOwner)
    fun clearPassword()
    fun setLoadingVisibility(enable: Boolean)
    fun startValidator()
}