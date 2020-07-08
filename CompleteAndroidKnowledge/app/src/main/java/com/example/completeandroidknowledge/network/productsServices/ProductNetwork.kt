package com.example.completeandroidknowledge.network.productsServices

import com.example.completeandroidknowledge.sectionTransactional.model.Product
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductNetwork (
    @Json(name = "id_bank_product")
    val idBankProduct: String = "",
    @Json(name="product_name")
    val productName: String = "",
    @Json(name="product_number_complete")
    val productNumberComplete: String = "",
    @Json(name="product_type")
    val productType: Int = 0,
    @Json(name="product_status")
    val productStatus: Int = 0,
    @Json(name="product_balance")
    val productBalance: Double = 0.0
)

fun ProductNetwork.asDomainObject(): Product{
    return Product(
        productBankId = idBankProduct,
        productNumber = productNumberComplete,
        productName = productName,
        productType = productType,
        productStatus = productStatus,
        productBalance = productBalance
    )
}