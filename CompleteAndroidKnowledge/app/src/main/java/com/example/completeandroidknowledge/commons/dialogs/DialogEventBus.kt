package com.example.completeandroidknowledge.commons.dialogs

import com.example.completeandroidknowledge.commons.BaseObservable
import java.util.*

class DialogEventBus: BaseObservable<DialogEventBus.Listener>() {
    interface Listener{
        fun onDialogEvent(event: Objects)
    }

    fun postEvent(event: Objects){
        getListeners().forEach {
            it.onDialogEvent(event)
        }
    }
}