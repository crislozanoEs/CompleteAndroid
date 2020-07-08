package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentTransactional
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModelFactory

class ProductSummaryFragmentPublic: BaseFragmentTransactional() {

    private lateinit var productSummaryFragmentMVCViewImpl: ProductSummaryFragmentMVCViewImpl
    private lateinit var viewModelFactory: ProductSummaryViewModelFactory
    private lateinit var viewModel: ProductSummaryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productSummaryFragmentMVCViewImpl = getCompositionRootObject().getViewMVCFactory().getProductSummaryFragmentMVCView(container)
        val application = requireNotNull(this.activity).application
        viewModelFactory = ProductSummaryViewModelFactory(
            getCompositionRootObject().getProductSummaryUseCaseImpl(application),
            application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductSummaryViewModel::class.java)
        productSummaryFragmentMVCViewImpl.setViewModel(viewModel)
        productSummaryFragmentMVCViewImpl.setAdapterProductSummary()
        viewModel.productSummary.observe(viewLifecycleOwner,  Observer {
            it?.let{
                productSummaryFragmentMVCViewImpl.setListDataToAdapter(it)
            }
        })
        return productSummaryFragmentMVCViewImpl.getRootView()
    }
}