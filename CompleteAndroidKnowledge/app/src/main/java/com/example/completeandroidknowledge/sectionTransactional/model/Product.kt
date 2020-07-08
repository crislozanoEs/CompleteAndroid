package com.example.completeandroidknowledge.sectionTransactional.model

import com.example.completeandroidknowledge.repository.productsDatabase.ProductTable


data class Product (
    var productBankId: String,
    var productNumber: String,
    var productNumberComplete: String,
    var productType: Int,
    var productStatus: Int,
    var productBalance: Double
)

fun Product.asDatabaseObject(): ProductTable{
    return ProductTable(
        idBankProduct = productBankId,
        productNumber = productNumber,
        productNumberComplete = productNumberComplete,
        productType = productType,
        productStatus = productStatus,
        productBalance = productBalance
    )
}