package com.example.completeandroidknowledge.commons

open class BaseObservable<TypeObservable> {

    private val listeners = mutableSetOf<TypeObservable>()

    fun registerListener(listener: TypeObservable) = listeners.add(listener)

    fun unregisterListener(listener: TypeObservable) = listeners.remove(listener)

    fun getListeners() : Set<TypeObservable> = listeners
}