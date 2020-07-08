package com.example.completeandroidknowledge.repository.productsDatabase

import com.example.completeandroidknowledge.commons.BaseObservable
import com.example.completeandroidknowledge.sectionTransactional.model.Product
import com.example.completeandroidknowledge.sectionTransactional.model.asDatabaseObject
import kotlinx.coroutines.*

class ProductSummaryDatabaseUseCaseImpl (private val productSummaryDatabaseDao: ProductSummaryDatabaseDao): BaseObservable<ProductSummaryDatabaseUseCaseImpl.Listener>(), ProductSummaryDatabaseUseCase {
    interface Listener{
        fun onProductSummaryRetrieved(products: List<Product>)
        fun onProductByIdRetrieved(product: Product)
    }

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  job)
    fun getJobObject() = job


    // Interface exposed methods
    override fun saveProductSummaryInDatabase(products: List<Product>) {
        uiScope.launch {
            saveProductSummaryInDataBase(products)
        }
    }
    override fun getProductSummaryInDatabase() {
        uiScope.launch {
            getProductSummaryInDataBase()
        }
    }
    override fun getProductById(productId: String) {
        uiScope.launch {
            getProductFromDatabase(productId)
        }
    }

    // Suspend functions
    private suspend fun saveProductSummaryInDataBase(products: List<Product>){
        withContext(Dispatchers.IO){
            val productsAsTable = mutableListOf<ProductTable>()
            products.forEach {
                productsAsTable.add(it.asDatabaseObject())
            }
            productSummaryDatabaseDao.insertAllProducts(productsAsTable)
        }
    }
    private suspend fun getProductFromDatabase(productId: String ){
        withContext(Dispatchers.IO){
           notifyProductByIdRetrieved(productSummaryDatabaseDao.get(productId).value!!.asDomainObject())
        }
    }
    private suspend fun getProductSummaryInDataBase(){
        withContext(Dispatchers.IO){
            val productsAsTable = productSummaryDatabaseDao.getAllProducts().value
            val products = mutableListOf<Product>()
            productsAsTable?.forEach {
                products.add(it.asDomainObject())
            }
            notifyProductSummaryRetrieved(products)
        }
    }

    // Notifiers
    private fun notifyProductByIdRetrieved(product: Product) {
        getListeners().forEach{
            it.onProductByIdRetrieved(product)
        }
    }
    private fun notifyProductSummaryRetrieved(products: MutableList<Product>) {
        getListeners().forEach{
            it.onProductSummaryRetrieved(products)
        }
    }
}