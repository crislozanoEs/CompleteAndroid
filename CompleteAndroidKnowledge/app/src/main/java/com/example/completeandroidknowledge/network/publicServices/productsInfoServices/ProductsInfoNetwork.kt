package com.example.completeandroidknowledge.network.publicServices.productsInfoServices

import com.example.completeandroidknowledge.sectionPublic.model.BankProduct
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsInfoNetwork(
    @Json(name="bank_product_id")
    val bankProductId: Int = 0,
    @Json(name="bank_product_image_id")
    val imageId: Int = 0,
    @Json(name="bank_product_text")
    var textProduct: String,
    @Json(name="bank_product_url")
    var urlProduct: String
)
fun ProductsInfoNetwork.asDomainObject(): BankProduct{
    return BankProduct(
        id = bankProductId,
        imageId = imageId,
        textProduct = textProduct,
        urlProduct = urlProduct
    )
}

