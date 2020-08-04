package com.example.completeandroidknowledge.sectionPublic

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.Constants
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

interface PublicActivityMVCView: ObservableViewMVC<PublicActivityMVCView.Listener, ActivityPublicBinding> {

    interface Listener{
        fun onFooterClicked(selected: Constants.Companion.FOOTER)
    }
    var binding: ActivityPublicBinding
}