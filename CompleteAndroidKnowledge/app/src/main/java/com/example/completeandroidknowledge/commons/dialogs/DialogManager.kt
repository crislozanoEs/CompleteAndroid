package com.example.completeandroidknowledge.commons.dialogs

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.sectionPublic.dialog.infoDialog.InfoDialogPublic
import com.example.completeandroidknowledge.sectionPublic.dialog.optionsDialog.OptionsDialogPublic

class DialogManager(private val context: Context, private val fragmentManager: FragmentManager) {

    fun showErrorOnlyOneAction(tag: String?, title: String, message: String, buttonCaption: String){
        val dialog = InfoDialogPublic.newInfoDialog(title,message,buttonCaption)
        dialog.show(fragmentManager, tag)
    }

    fun showErrorOnlyTwoAction(tag: String?, title: String, message: String, buttonPositiveCaption: String, buttonNegativeCaption: String){
        val dialog = OptionsDialogPublic.newOptionsDialog(title,message,buttonPositiveCaption, buttonNegativeCaption)
        dialog.show(fragmentManager, tag)
    }
}