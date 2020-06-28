package com.example.completeandroidknowledge.commons.dialogs

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.commons.dialogs.infoDialog.InfoDialog

class DialogManager(private val context: Context, private val fragmentManager: FragmentManager) {

    fun showErrorOnlyOneAction(tag: String?, title: String, message: String, buttonCaption: String){
        var dialog = InfoDialog.newInfoDialog(title,message,buttonCaption)
        dialog.show(fragmentManager, tag)

    }
}