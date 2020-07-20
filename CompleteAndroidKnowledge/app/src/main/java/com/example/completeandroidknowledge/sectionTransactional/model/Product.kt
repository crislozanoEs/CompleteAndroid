package com.example.completeandroidknowledge.sectionTransactional.model

import com.example.completeandroidknowledge.repository.productsDatabase.ProductTable


data class Product (
    var productBankId: String,
    var productNumber: String,
    var productName: String,
    var productType: Int,
    var productStatus: Int,
    var productBalance: Double,
    var isOpened: Boolean = false
)

fun Product.asDatabaseObject(): ProductTable{
    return ProductTable(
        idBankProduct = productBankId,
        productNumber = productNumber,
        productName = productName,
        productType = productType,
        productStatus = productStatus,
        productBalance = productBalance
    )
}