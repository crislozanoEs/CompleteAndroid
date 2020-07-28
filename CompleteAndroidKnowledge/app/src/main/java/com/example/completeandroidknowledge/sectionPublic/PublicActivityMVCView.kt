package com.example.completeandroidknowledge.sectionPublic

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

interface PublicActivityMVCView: ObservableViewMVC<PublicActivityMVCView.Listener, ActivityPublicBinding> {

    interface Listener{
        fun goFromLoginFragmentToProductsInfo()
        fun goFromProductsInfoToLoginFragment()
    }
    var binding: ActivityPublicBinding
    fun setLifeCycleOwnerView(owner: LifecycleOwner)
}