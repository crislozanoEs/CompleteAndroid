package com.example.completeandroidknowledge.section2.dialog.optionsDialog

import android.app.Dialog
import android.os.Bundle
import com.example.completeandroidknowledge.commons.dialogs.BaseDialogMain
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogEvent
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCView

class OptionsDialog(): BaseDialogMain(),
    OptionDialogMVCView.Listener {

    private lateinit var dialogEventBus: DialogEventBus
    private lateinit var optionDialogMVCView: OptionDialogMVCView

    companion object{
        private val ARG_TITLE = "ARG_TITLE"
        private val ARG_MESSAGE = "ARG_MESSAGE"
        private val ARG_POSITIVE_BUTTON_CAPTION = "ARG_POSITIVE_BUTTON_CAPTION"
        private val ARG_NEGATIVE_BUTTON_CAPTION = "ARG_NEGATIVE_BUTTON_CAPTION"
        fun newOptionsDialog(title: String, message: String, positiveButtonCaption: String, negativeButtonCaption: String): OptionsDialog {
            val infoDialog =
                OptionsDialog();
            val bundle = Bundle(3)
            bundle.putString(ARG_TITLE, title)
            bundle.putString(ARG_MESSAGE, message)
            bundle.putString(ARG_POSITIVE_BUTTON_CAPTION, positiveButtonCaption)
            bundle.putString(ARG_NEGATIVE_BUTTON_CAPTION, negativeButtonCaption)
            infoDialog.arguments = bundle
            return infoDialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogEventBus = getCompositionRoot()!!.getDialogEventBus()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if(arguments == null){
            throw IllegalStateException("Arguments must not be empty")
        }
        optionDialogMVCView = getCompositionRoot()!!.getViewMVCFactory().getOptionDialogMVCView(null)
        optionDialogMVCView.setTitle(arguments!!.getString(ARG_TITLE)!!)
        optionDialogMVCView.setMessage(arguments!!.getString(ARG_MESSAGE)!!)
        optionDialogMVCView.setNegativeCaption(arguments!!.getString(ARG_NEGATIVE_BUTTON_CAPTION)!!)
        optionDialogMVCView.setPositiveCaption(arguments!!.getString(ARG_POSITIVE_BUTTON_CAPTION)!!)
        val dialog = Dialog(requireContext())
        dialog.setContentView(optionDialogMVCView.getRootView())
        return dialog
    }

    override fun onStart() {
        super.onStart()
        optionDialogMVCView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        optionDialogMVCView.unregisterListener(this)
    }
    private fun onButtonClick() {
        dismiss()
    }

    override fun onPositiveButtonClicked() {
        onButtonClick()
        dialogEventBus.postEvent(
            OptionDialogEvent(
                OptionDialogEvent.Button.POSITIVE
            )
        )

    }

    override fun onNegativeButtonClicked() {
        onButtonClick()
        dialogEventBus.postEvent(
            OptionDialogEvent(
                OptionDialogEvent.Button.NEGATIVE
            )
        )
    }
}