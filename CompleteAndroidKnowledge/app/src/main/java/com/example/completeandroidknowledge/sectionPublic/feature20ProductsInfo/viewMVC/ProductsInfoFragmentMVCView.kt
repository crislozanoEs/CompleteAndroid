package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.ProductInfoBinding
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel

interface ProductsInfoFragmentMVCView:
    ObservableViewMVC<ProductsInfoFragmentMVCView.Listener,ProductInfoBinding> {

    interface Listener{

    }
    val binding: ProductInfoBinding
    fun setViewModel(viewModel: ProductsInfoViewModel)
}