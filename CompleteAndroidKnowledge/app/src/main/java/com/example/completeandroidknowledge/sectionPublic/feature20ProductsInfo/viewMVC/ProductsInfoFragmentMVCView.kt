package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC

import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.ProductInfoBinding
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

interface ProductsInfoFragmentMVCView:
    ObservableViewMVC<ProductsInfoFragmentMVCView.Listener,ProductInfoBinding> {

    interface Listener{
        fun onBankProductClicked()
    }
    val binding: ProductInfoBinding
    fun setViewModel(viewModel: ProductsInfoViewModel)
    fun setAdapterBankProducts()
    fun setListBankProducts(bankProducts: List<BankProduct>)
}