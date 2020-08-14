package com.example.completeandroidknowledge.network.publicServices.productsInfoServices

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.network.publicServices.PublicAPI
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import java.lang.Exception

class ProductsInfoUseCase(private val publicAPI: PublicAPI):
    BaseObservable<ProductsInfoUseCase.Listener>() {

    interface Listener{
        fun onProductsInfoSucceed(productsInfo: List<BankProduct>)
        fun onProductsInfoError()
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)
    fun getJobObject() = job

    fun executeCallProductsInfo(){
        uiScope.launch {
            callProductsInfo()
        }
    }

    private suspend fun callProductsInfo() {
        withContext(Dispatchers.IO){
            val bankProductsDeferred = publicAPI.getProductsInfoAsync()
            try{
                val bankProducts = bankProductsDeferred.await()
                notifyProductsInfoSucceed(bankProducts)
            }catch (e: Exception){
                notifyProductsInfoError()
            }
        }
    }

    private fun notifyProductsInfoError() {
        getListeners().forEach {
            it.onProductsInfoError()
        }
    }

    private fun notifyProductsInfoSucceed(products: List<ProductsInfoNetwork>) {
        val listToReturn = products.map {
            it.asDomainObject()
        }
        getListeners().forEach {
            it.onProductsInfoSucceed(listToReturn)
        }
    }

}