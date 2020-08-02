package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.ProductInfoBinding
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel

class ProductsInfoFragmentMVCViewImpl(layoutInflater: LayoutInflater, parent: ViewGroup?) : ProductsInfoFragmentMVCView,
    ObservableViewMVCImpl<ProductsInfoFragmentMVCView.Listener, ProductInfoBinding>(){

    override val binding: ProductInfoBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_info, parent, false)

    init {
        setRootView(binding.root)
    }
    override fun setViewModel(viewModel: ProductsInfoViewModel) {
        TODO("Not yet implemented")
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }
}