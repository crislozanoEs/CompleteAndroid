package com.example.completeandroidknowledge.commons.views

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

open class ViewMVCImpl<BindingType : ViewDataBinding>: ViewMVC<BindingType> {
    private lateinit var rootView: View

    override fun getRootView(): View {
        return  rootView
    }

    fun setRootView(view: View) {
        rootView = view
    }

    fun getContext(): Context = rootView.context

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        // Each view implements it, TO DO: IMPROVE IT
    }
}