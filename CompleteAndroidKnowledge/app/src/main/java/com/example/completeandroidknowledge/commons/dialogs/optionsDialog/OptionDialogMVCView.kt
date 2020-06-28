package com.example.completeandroidknowledge.commons.dialogs.optionsDialog

import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.DialogOptionsBinding

interface OptionDialogMVCView : ObservableViewMVC<OptionDialogMVCView.Listener, DialogOptionsBinding> {

    interface Listener{
        fun onPositiveButtonClicked()
        fun onNegativeButtonClicked()
    }

    var binding: DialogOptionsBinding

    fun setTitle(title: String)

    fun setMessage(message: String)

    fun setPositiveCaption(caption: String)

    fun setNegativeCaption(caption: String)
}