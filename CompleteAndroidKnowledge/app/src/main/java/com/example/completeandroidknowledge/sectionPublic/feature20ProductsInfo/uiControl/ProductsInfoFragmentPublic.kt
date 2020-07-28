package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC.ProductsInfoFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel

class ProductsInfoFragmentPublic : BaseFragmentPublic() {

    private lateinit var productsInfoFragmentMVCViewImpl: ProductsInfoFragmentMVCView
    private lateinit var viewModel: ProductsInfoViewModel
    private lateinit var navigation: Navigation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productsInfoFragmentMVCViewImpl = getCompositionRootObject().getViewMVCFactory().getProductsInfoFragmentMVCView(container)
        viewModel = ViewModelProvider(this).get(ProductsInfoViewModel::class.java)

        return productsInfoFragmentMVCViewImpl.getRootView()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}
