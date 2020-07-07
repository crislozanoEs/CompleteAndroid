package com.example.completeandroidknowledge.commons.controllers

import androidx.fragment.app.Fragment
import com.example.completeandroidknowledge.commons.dependencyInjection.ControllerCompositionRoot
import com.example.completeandroidknowledge.sectionTransactional.MainActivity

open class BaseFragmentTransactional: Fragment() {
    private var compositionRoot: ControllerCompositionRoot?  = null
    fun getCompositionRootObject(): ControllerCompositionRoot {
        if(compositionRoot == null){
            val activity = requireActivity() as MainActivity
            compositionRoot = ControllerCompositionRoot(activity.activityCompositionRoot)
        }
        return compositionRoot as ControllerCompositionRoot
    }
}