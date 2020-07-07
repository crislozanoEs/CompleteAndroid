package com.example.completeandroidknowledge.commons.dialogs

import androidx.fragment.app.DialogFragment
import com.example.completeandroidknowledge.commons.dependencyInjection.ControllerCompositionRoot
import com.example.completeandroidknowledge.sectionTransactional.MainActivity

open class BaseDialogMain: DialogFragment() {

    private var controllerCompositionRoot: ControllerCompositionRoot? = null

    fun getCompositionRoot(): ControllerCompositionRoot?{
        if(controllerCompositionRoot == null){
            val activity = requireActivity() as MainActivity
            controllerCompositionRoot = ControllerCompositionRoot(activity.activityCompositionRoot)
        }
        return controllerCompositionRoot
    }
}