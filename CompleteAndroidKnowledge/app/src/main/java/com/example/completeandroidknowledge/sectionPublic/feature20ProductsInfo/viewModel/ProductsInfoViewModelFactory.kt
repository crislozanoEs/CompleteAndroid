package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.network.publicServices.productsInfoServices.ProductsInfoUseCase

@Suppress("UNCHECKED_CAST")
class ProductsInfoViewModelFactory (private val productsInfoUseCase: ProductsInfoUseCase):
    ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsInfoViewModel::class.java)) {
            return ProductsInfoViewModel(productsInfoUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}