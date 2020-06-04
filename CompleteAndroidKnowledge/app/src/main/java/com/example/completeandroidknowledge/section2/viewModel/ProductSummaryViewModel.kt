package com.example.completeandroidknowledge.section2.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section2.model.Product
import com.example.completeandroidknowledge.section2.model.ProductSummaryDatabaseDao
import kotlinx.coroutines.*

class ProductSummaryViewModel (val productSummaryDatabaseDao: ProductSummaryDatabaseDao, val application: Application): ViewModel(){

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _productSummary =  MutableLiveData<List<Product>>()
    val productSummary: LiveData<List<Product>>
        get() = _productSummary

    fun saveProductSummary(products: List<Product>){
        uiScope.launch {
            saveProductSummaryInDataBase(products)
        }
    }

    private suspend fun saveProductSummaryInDataBase(products: List<Product>){
        withContext(Dispatchers.IO){
            productSummaryDatabaseDao.insertAllProducts(products)
        }
    }

    fun getProductSummary(){
        uiScope.launch {
            getProductSummaryInDataBase()
        }
    }

    private suspend fun getProductSummaryInDataBase(){
        withContext(Dispatchers.IO){
            _productSummary.value = productSummaryDatabaseDao.getAllProducts().value
        }
    }

}