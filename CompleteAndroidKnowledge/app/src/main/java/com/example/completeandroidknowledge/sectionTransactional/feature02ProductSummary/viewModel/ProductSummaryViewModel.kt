package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.network.productsServices.ProductSummaryServiceUseCase
import com.example.completeandroidknowledge.repository.productsDatabase.ProductTable
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabaseUseCaseImpl
import com.example.completeandroidknowledge.sectionTransactional.model.Product
import kotlinx.coroutines.*

class ProductSummaryViewModel (private val productSummaryDatabaseUseCaseImpl: ProductSummaryDatabaseUseCaseImpl,
                               private val productSummaryServiceUseCase: ProductSummaryServiceUseCase,
                               val application: Application):
    ViewModel(),
    ProductSummaryServiceUseCase.Listener{

    enum class STATE{
        IDLE, LOADING, PRODUCT_SUMMARY_SUCCEED, PRODUCT_SUMMARY_FAILED
    }

    private var _currentState =  MutableLiveData<STATE>()
    val currentState: LiveData<STATE>
        get() = _currentState

    private var _productSummary =  MutableLiveData<List<Product>>()
    val productSummary: LiveData<List<Product>>
        get() = _productSummary

    private fun saveProductSummary(){
        productSummaryDatabaseUseCaseImpl.saveProductSummaryInDatabase(_productSummary.value!!)
    }

    init{
        _currentState.value = STATE.IDLE
        productSummaryServiceUseCase.registerListener(this)
    }

    fun startGettingProductSummary(){
        _currentState.value = STATE.LOADING
        productSummaryServiceUseCase.executeGetProductSummary()
    }
    fun getProductSummaryFromDatabase(){
        productSummaryDatabaseUseCaseImpl.getProductSummaryInDatabase()
    }

    override fun onCleared() {
        super.onCleared()
        productSummaryDatabaseUseCaseImpl.getJobObject().cancel()
        productSummaryServiceUseCase.getJobObject().cancel()
        productSummaryServiceUseCase.unregisterListener(this)
    }

    override fun onProductSummarySucceed(productSummary: List<Product>) {
        _productSummary.postValue(productSummary)
        _currentState.postValue( STATE.PRODUCT_SUMMARY_SUCCEED)
        saveProductSummary()
    }

    override fun onProductSummaryFailed() {
        _currentState.postValue(STATE.PRODUCT_SUMMARY_FAILED)
    }

}