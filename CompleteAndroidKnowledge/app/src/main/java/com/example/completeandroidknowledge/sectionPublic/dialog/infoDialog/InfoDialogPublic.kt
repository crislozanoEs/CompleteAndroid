package com.example.completeandroidknowledge.sectionPublic.dialog.infoDialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.dialogs.BaseDialogPublic
import com.example.completeandroidknowledge.databinding.DialogInfoBinding

class InfoDialogPublic(): BaseDialogPublic() {

    private val ARG_TITLE = "ARG_TITLE"
    private val ARG_MESSAGE = "ARG_MESSAGE"
    private val ARG_BUTTON_CAPTION = "ARG_BUTTON_CAPTION"

    private lateinit var infoBinding: DialogInfoBinding

    companion object{
        private val ARG_TITLE = "ARG_TITLE"
        private val ARG_MESSAGE = "ARG_MESSAGE"
        private val ARG_BUTTON_CAPTION = "ARG_BUTTON_CAPTION"
        fun newInfoDialog(title: String, message: String, buttonCaption: String): InfoDialogPublic {
            val infoDialog =
                InfoDialogPublic();
            val bundle = Bundle(3)
            bundle.putString(ARG_TITLE, title)
            bundle.putString(ARG_MESSAGE, message)
            bundle.putString(ARG_BUTTON_CAPTION, buttonCaption)
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