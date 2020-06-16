package com.example.completeandroidknowledge.commons.views

import androidx.databinding.ViewDataBinding

interface ObservableViewMVC<ListenerType, BindingType : ViewDataBinding>: ViewMVC<BindingType> {
    fun registerListener(listener: ListenerType): Boolean

    fun unregisterListener(listener: ListenerType): Boolean
}