package com.example.completeandroidknowledge.commons.dialogs

import com.example.completeandroidknowledge.commons.BaseObservable
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

open class DialogEventBus: BaseObservable<DialogEventBus.Listener>() {
    interface Listener{
        fun onDialogEvent(event: Any)
    }

    fun postEvent(event: Any){
        getListeners().forEach {
            it.onDialogEvent(event)
        }
    }
}