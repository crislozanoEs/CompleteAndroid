package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.network.publicServices.productsInfoServices.ProductsInfoUseCase
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

enum class STATE{
    LOADING, PRODUCTS_INFO_SUCCEED, PRODUCTS_INFO_FAILED, PRODUCTS_INFO_SELECTED
}
class ProductsInfoViewModel(
    private val productsInfoUseCase: ProductsInfoUseCase) :
    ViewModel(),
    ProductsInfoUseCase.Listener{
    private val _products = MutableLiveData<List<BankProduct>>()
    val products: LiveData<List<BankProduct>>
        get() = _products

    private val _currentState = MutableLiveData<STATE>()
    val currentState: LiveData<STATE>
        get() = _currentState

    init {
        productsInfoUseCase.registerListener(this)
        _currentState.value = STATE.LOADING
        executeProductsInfoService()
    }

    private fun executeProductsInfoService() {
        productsInfoUseCase.executeCallProductsInfo()
    }


    override fun onCleared() {
        productsInfoUseCase.getJobObject().cancel()
        productsInfoUseCase.unregisterListener(this)
        super.onCleared()
    }


    override fun onProductsInfoSucceed(productsInfo: List<BankProduct>) {
        _products.postValue(productsInfo)
        _currentState.postValue(STATE.PRODUCTS_INFO_SUCCEED)
    }

    override fun onProductsInfoError() {
        _currentState.postValue(STATE.PRODUCTS_INFO_FAILED)
    }
}