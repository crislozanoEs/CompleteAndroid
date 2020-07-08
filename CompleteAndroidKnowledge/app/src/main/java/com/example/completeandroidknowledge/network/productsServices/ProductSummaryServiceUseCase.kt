package com.example.completeandroidknowledge.network.productsServices

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.sectionTransactional.model.Product
import kotlinx.coroutines.*

class ProductSummaryServiceUseCase(private val productAPI: ProductAPI):
    BaseObservable<ProductSummaryServiceUseCase.Listener>() {

    interface Listener{
        fun onProductSummarySucceed(productSummary: List<Product>)
        fun onProductSummaryFailed()
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)


    fun getJobObject() = job

    fun executeGetProductSummary(){
        uiScope.launch {
            callGetProductSummaryService()
        }
    }

    private suspend fun callGetProductSummaryService() {
        withContext(Dispatchers.IO){
            val productSummaryDeferred = productAPI.getProductSummary()
            try{
                val productSummary = productSummaryDeferred.await()
                notifyProductSummarySucceed(productSummary)
            }catch (e: Exception){
                notifyProductSummaryFailed()
            }
        }
    }

    private fun notifyProductSummaryFailed() {
        getListeners().forEach {
            it.onProductSummaryFailed()
        }
    }

    private fun notifyProductSummarySucceed(productSummary: List<ProductNetwork>) {
        val productSummaryAsDomain = mutableListOf<Product>()
        productSummary.forEach {
            productSummaryAsDomain.add(it.asDomainObject())
        }
        getListeners().forEach {
            it.onProductSummarySucceed(productSummaryAsDomain)
        }
    }
}