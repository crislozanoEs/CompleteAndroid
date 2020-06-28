package com.example.completeandroidknowledge.commons.dialogs.optionsDialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.DialogOptionsBinding


class OptionDialogMVCViewImpl(inflater: LayoutInflater, parent: ViewGroup?):
    OptionDialogMVCView, ObservableViewMVCImpl<OptionDialogMVCView.Listener, DialogOptionsBinding>(){

    override var binding: DialogOptionsBinding =
        DataBindingUtil.inflate(inflater,R.layout.dialog_options, parent,false)

    init{
        binding.btnNegative.setOnClickListener {
            getListener().forEach {
                it.onNegativeButtonClicked()
            }
        }

        binding.btnPositive.setOnClickListener {
            getListener().forEach {
                it.onPositiveButtonClicked()
            }
        }
        setRootView(binding.root)
    }

    override fun setTitle(title: String) {
        binding.txtTitleDialog.text = title
    }

    override fun setMessage(message: String) {
        binding.txtMessageDialog.text = message
    }

    override fun setPositiveCaption(caption: String) {
        binding.btnPositive.text = caption
    }

    override fun setNegativeCaption(caption: String) {
        binding.btnNegative.text = caption
    }

}