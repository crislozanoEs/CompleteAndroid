package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.ProductSummaryFragmentBinding
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.adapters.ProductAdapter
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.sectionTransactional.model.Product

class ProductSummaryFragmentMVCViewImpl(inflater: LayoutInflater, parent: ViewGroup?): ProductSummaryFragmentMVCView,
    ObservableViewMVCImpl<ProductSummaryFragmentMVCView.Listener, ProductSummaryFragmentBinding>() {

    private lateinit var productAdapter: ProductAdapter

    override var binding: ProductSummaryFragmentBinding =
        DataBindingUtil.inflate(inflater, R.layout.product_summary_fragment, parent,false)

    override fun setViewModel(viewModel: ProductSummaryViewModel) {
        binding.productSummaryViewModel = viewModel
    }

    override fun getRootView(): View = binding.root

    override fun setLifeCycleOwnerView(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }

    override fun setAdapterProductSummary() {
        productAdapter =
            ProductAdapter()
        binding.productSummaryList.adapter = productAdapter
    }

    override fun setListDataToAdapter(products: List<Product>) {
        productAdapter.submitList(products)
    }

    fun showLoading(showLoading: Boolean){
        if(showLoading)
            binding.loadingProgress.visibility = View.VISIBLE
        else
            binding.loadingProgress.visibility = View.GONE
    }

}