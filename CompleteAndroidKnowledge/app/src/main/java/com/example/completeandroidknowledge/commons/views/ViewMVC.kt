package com.example.completeandroidknowledge.commons.views

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

interface ViewMVC<BindingType : ViewDataBinding> {
    fun getRootView(): View
    fun setLifecycleOwner(binding: BindingType, owner: LifecycleOwner)
}