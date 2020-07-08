package com.example.completeandroidknowledge.repository.productsDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.completeandroidknowledge.sectionTransactional.model.Product

@Entity(tableName = "products_table")
data class ProductTable(
    @PrimaryKey(autoGenerate = true)
    var idProduct: Int? = null,
    @ColumnInfo(name = "product_id_bank")
    var idBankProduct: String,
    @ColumnInfo(name = "Product_number")
    var productNumber: String,
    @ColumnInfo(name = "Product_name")
    var productName: String,
    @ColumnInfo(name = "Product_type")
    var productType: Int,
    @ColumnInfo(name = "Product_status")
    var productStatus: Int,
    @ColumnInfo(name = "Product_balance")
    var productBalance: Double
    )

fun ProductTable.asDomainObject(): Product {
    return Product(
        productBankId = idBankProduct,
        productNumber = productNumber,
        productName = productName,
        productType = productType,
        productStatus = productStatus,
        productBalance = productBalance
    )
}