package com.example.completeandroidknowledge.repository.productsDatabase

import com.example.completeandroidknowledge.sectionTransactional.model.Product

interface ProductSummaryDatabaseUseCase {
    fun saveProductSummaryInDatabase(products: List<Product>)
    fun getProductSummaryInDatabase()
    fun getProductById(productId: String)

}