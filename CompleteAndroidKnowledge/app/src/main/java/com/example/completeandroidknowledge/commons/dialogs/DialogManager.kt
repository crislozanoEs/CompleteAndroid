package com.example.completeandroidknowledge.commons.dialogs

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.commons.dialogs.infoDialog.InfoDialog
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionsDialog

class DialogManager(private val context: Context, private val fragmentManager: FragmentManager) {

    fun showErrorOnlyOneAction(tag: String?, title: String, message: String, buttonCaption: String){
        val dialog = InfoDialog.newInfoDialog(title,message,buttonCaption)
        dialog.show(fragmentManager, tag)
    }

    fun showErrorOnlyTwoAction(tag: String?, title: String, message: String, buttonPositiveCaption: String, buttonNegativeCaption: String){
        val dialog = OptionsDialog.newOptionsDialog(title,message,buttonPositiveCaption, buttonNegativeCaption)
        dialog.show(fragmentManager, tag)
    }
}