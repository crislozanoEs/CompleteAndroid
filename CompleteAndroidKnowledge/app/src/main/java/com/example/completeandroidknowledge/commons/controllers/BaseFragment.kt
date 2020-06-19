package com.example.completeandroidknowledge.commons.controllers
import androidx.fragment.app.Fragment
import com.example.completeandroidknowledge.commons.dependencyInjection.ControllerCompositionRoot

open class BaseFragment: Fragment() {
    private var compositionRoot: ControllerCompositionRoot?  = null
    fun getCompositionRootObject(): ControllerCompositionRoot{
        if(compositionRoot == null){
            val activity = requireActivity() as BaseActivity
            compositionRoot = ControllerCompositionRoot(activity.activityCompositionRoot)
        }
        return compositionRoot as ControllerCompositionRoot
    }
}