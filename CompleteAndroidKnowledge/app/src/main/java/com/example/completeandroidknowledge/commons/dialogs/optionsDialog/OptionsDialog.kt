package com.example.completeandroidknowledge.commons.dialogs.optionsDialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.dialogs.BaseDialog
import com.example.completeandroidknowledge.databinding.DialogInfoBinding

class OptionsDialog(): BaseDialog() {

    private val ARG_TITLE = "ARG_TITLE"
    private val ARG_MESSAGE = "ARG_MESSAGE"
    private val ARG_BUTTON_CAPTION = "ARG_BUTTON_CAPTION"

    private lateinit var infoBinding: DialogInfoBinding

    companion object{
        private val ARG_TITLE = "ARG_TITLE"
        private val ARG_MESSAGE = "ARG_MESSAGE"
        private val ARG_POSITIVE_BUTTON_CAPTION = "ARG_POSITIVE_BUTTON_CAPTION"
        private val ARG_NEGATIVE_BUTTON_CAPTION = "ARG_NEGATIVE_BUTTON_CAPTION"
        fun newInfoDialog(title: String, message: String, positiveButtonCaption: String, negativeButtonCaption: String): OptionsDialog{
            val infoDialog = OptionsDialog();
            val bundle = Bundle(3)
            bundle.putString(ARG_TITLE, title)
            bundle.putString(ARG_MESSAGE, message)
            bundle.putString(ARG_POSITIVE_BUTTON_CAPTION, positiveButtonCaption)
            bundle.putString(ARG_NEGATIVE_BUTTON_CAPTION, negativeButtonCaption)
            infoDialog.arguments = bundle
            return infoDialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if(arguments == null){
            throw IllegalStateException("Arguments must not be empty")
        }
        val dialog = Dialog(requireContext())
        infoBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_info,null, false)
        dialog.setContentView(infoBinding.root)
        infoBinding.btnPositive.text = arguments!!.getString(ARG_BUTTON_CAPTION)
        infoBinding.txtTitleDialog.text = arguments!!.getString(ARG_TITLE)
        infoBinding.txtMessageDialog.text = arguments!!.getString(ARG_MESSAGE)
        infoBinding.btnPositive.setOnClickListener {
            onButtonClick()
        }
        return dialog
    }

    private fun onButtonClick() {
        dismiss()
    }
}