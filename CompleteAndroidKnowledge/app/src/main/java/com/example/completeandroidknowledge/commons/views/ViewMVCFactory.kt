package com.example.completeandroidknowledge.commons.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCView
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.PublicActivity
import com.example.completeandroidknowledge.sectionPublic.PublicActivityMVCView
import com.example.completeandroidknowledge.sectionPublic.PublicActivityMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC.LoginFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC.LoginFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.feature01User.viewMVC.UserFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature01User.viewMVC.UserFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC.ProductsInfoFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC.ProductsInfoFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CameraFun
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC.NewsFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC.NewsFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCView
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCViewImpl

class ViewMVCFactory(private val layoutInflater: LayoutInflater) {

    fun getLoginFragmentMVCView(parent: ViewGroup?): LoginFragmentMVCView =
        LoginFragmentMVCViewImpl(
            layoutInflater,
            parent
        )
    fun getUserFragmentMVCView(parent: ViewGroup?): UserFragmentMVCView =
        UserFragmentMVCViewImpl(
            layoutInflater,
            parent
        )
    fun getOptionDialogMVCView(parent: ViewGroup?): OptionDialogMVCView =
        OptionDialogMVCViewImpl(
            layoutInflater,
            parent
        )

    fun getProductSummaryFragmentMVCView(parent: ViewGroup?): ProductSummaryFragmentMVCViewImpl =
        ProductSummaryFragmentMVCViewImpl(
            layoutInflater,
            parent
        )

    fun getProductsInfoFragmentMVCView(parent: ViewGroup?): ProductsInfoFragmentMVCView =
        ProductsInfoFragmentMVCViewImpl(
            layoutInflater,
            parent
        )

    fun getNewsFragmentMVCView(container: ViewGroup?): NewsFragmentMVCView  =
        NewsFragmentMVCViewImpl(
            layoutInflater,
            container
        )
}