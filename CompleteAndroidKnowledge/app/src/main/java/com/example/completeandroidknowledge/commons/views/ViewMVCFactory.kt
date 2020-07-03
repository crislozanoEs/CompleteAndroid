package com.example.completeandroidknowledge.commons.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCView
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCViewImpl
import com.example.completeandroidknowledge.section1.uiControllers.PublicActivity
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.LoginFragmentMVCView
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.LoginFragmentMVCViewImpl
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.UserFragmentMVCView
import com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews.UserFragmentMVCViewImpl

class ViewMVCFactory(private val layoutInflater: LayoutInflater) {

    fun getLoginFragmentMVCView(parent: ViewGroup?): LoginFragmentMVCView = LoginFragmentMVCViewImpl(layoutInflater, parent)
    fun getUserFragmentMVCView(parent: ViewGroup?, activity: PublicActivity): UserFragmentMVCView = UserFragmentMVCViewImpl(layoutInflater, parent, activity)
    fun getOptionDialogMVCView(parent: ViewGroup?): OptionDialogMVCView = OptionDialogMVCViewImpl(layoutInflater, parent)
}