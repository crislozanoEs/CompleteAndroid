package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.repository.productsDatabase.ProductTable
import com.example.completeandroidknowledge.repository.productsDatabase.ProductSummaryDatabaseUseCaseImpl
import com.example.completeandroidknowledge.sectionTransactional.model.Product
import kotlinx.coroutines.*

class ProductSummaryViewModel (private val productSummaryDatabaseUseCaseImpl: ProductSummaryDatabaseUseCaseImpl, val application: Application): ViewModel(){

    private var _productSummary =  MutableLiveData<List<Product>>()
    val productSummary: LiveData<List<Product>>
        get() = _productSummary

    fun saveProductSummary(){
        productSummaryDatabaseUseCaseImpl.saveProductSummaryInDatabase(_productSummary.value!!)
    }



    fun getProductSummary(){
        productSummaryDatabaseUseCaseImpl.getProductSummaryInDatabase()
    }

    override fun onCleared() {
        super.onCleared()
        productSummaryDatabaseUseCaseImpl.getJobObject().cancel()
    }

}