package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.ProductSummaryFragmentBinding
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.sectionTransactional.model.Product

interface ProductSummaryFragmentMVCView : ObservableViewMVC<ProductSummaryFragmentMVCView.Listener, ProductSummaryFragmentBinding>{
    interface Listener{
        fun onRetryButtonClicked()
        fun onProductClicked(product: Product)
    }
    var binding: ProductSummaryFragmentBinding
    fun setViewModel(viewModel: ProductSummaryViewModel)
    fun setLifeCycleOwnerView(owner: LifecycleOwner)
    fun setAdapterProductSummary()
    fun setListDataToAdapter(products: List<Product>)
}