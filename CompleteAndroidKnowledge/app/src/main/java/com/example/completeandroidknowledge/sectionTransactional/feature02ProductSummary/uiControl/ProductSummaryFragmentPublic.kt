package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentTransactional
import com.example.completeandroidknowledge.databinding.ProductSummaryFragmentBinding
import com.example.completeandroidknowledge.sectionTransactional.model.ProductSummaryDatabase
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCView
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModelFactory

class ProductSummaryFragmentPublic: BaseFragmentTransactional() {

    private lateinit var binding: ProductSummaryFragmentBinding
    private lateinit var productSummaryFragmentMVCView: ProductSummaryFragmentMVCView
    private lateinit var viewModelFactory: ProductSummaryViewModelFactory
    private lateinit var viewModel: ProductSummaryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productSummaryFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getProductSummaryFragmentMVCView(container)
        // binding.user = user
        val application = requireNotNull(this.activity).application
        val dataSource = ProductSummaryDatabase.getInstance(application).productSummaryDatabaseDao
        viewModelFactory = ProductSummaryViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductSummaryViewModel::class.java)
        productSummaryFragmentMVCView.setViewModel(viewModel)
        productSummaryFragmentMVCView.setAdapterProductSummary()
        temporalInitProductSummary()
        viewModel.productSummary.observe(viewLifecycleOwner,  Observer {
            it?.let{
                productSummaryFragmentMVCView.setListDataToAdapter(it)
            }
        })
        return productSummaryFragmentMVCView.getRootView()
    }

    private fun temporalInitProductSummary(){
        viewModel.temporalInitProductSummary()
    }

}