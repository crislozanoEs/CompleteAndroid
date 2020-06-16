package com.example.completeandroidknowledge.commons.views

import androidx.databinding.ViewDataBinding

abstract class ObservableViewMVCImpl<ListenerType, BindingType : ViewDataBinding>: ViewMVCImpl<BindingType>(), ObservableViewMVC<ListenerType, BindingType> {

    private val listeners = mutableSetOf<ListenerType>()

    override fun registerListener(listener: ListenerType) = listeners.add(listener)

    override fun unregisterListener(listener: ListenerType) = listeners.remove(listener)

    fun getListener() : Set<ListenerType> = listeners


}