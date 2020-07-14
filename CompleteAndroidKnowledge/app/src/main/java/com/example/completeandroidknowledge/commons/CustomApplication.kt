package com.example.completeandroidknowledge.commons

import android.app.Application
import com.example.completeandroidknowledge.commons.dependencyInjection.CompositionRoot

class CustomApplication: Application() {
    private lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot(this)
    }

    fun getCompositionRoot(): CompositionRoot = compositionRoot


}