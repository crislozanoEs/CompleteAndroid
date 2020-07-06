package com.example.completeandroidknowledge.commons.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCView
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCViewImpl
import com.example.completeandroidknowledge.publicSection.PublicActivity
import com.example.completeandroidknowledge.publicSection.feature01Login.viewMVC.LoginFragmentMVCView
import com.example.completeandroidknowledge.publicSection.feature01Login.viewMVC.LoginFragmentMVCViewImpl
import com.example.completeandroidknowledge.publicSection.feature01User.viewMVC.UserFragmentMVCView
import com.example.completeandroidknowledge.publicSection.feature01User.viewMVC.UserFragmentMVCViewImpl

class ViewMVCFactory(private val layoutInflater: LayoutInflater) {

    fun getLoginFragmentMVCView(parent: ViewGroup?): LoginFragmentMVCView =
        LoginFragmentMVCViewImpl(
            layoutInflater,
            parent
        )
    fun getUserFragmentMVCView(parent: ViewGroup?, activity: PublicActivity): UserFragmentMVCView =
        UserFragmentMVCViewImpl(
            layoutInflater,
            parent,
            activity
        )
    fun getOptionDialogMVCView(parent: ViewGroup?): OptionDialogMVCView = OptionDialogMVCViewImpl(layoutInflater, parent)
}