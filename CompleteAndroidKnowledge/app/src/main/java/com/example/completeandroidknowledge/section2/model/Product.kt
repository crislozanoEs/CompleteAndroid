package com.example.completeandroidknowledge.section2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var idProduct: String,
    @ColumnInfo(name = "Product_number")
    var productNumber: String,
    @ColumnInfo(name = "Complete_product_number")
    var productNumberComplete: String,
    @ColumnInfo(name = "Product_type")
    var productType: Int,
    @ColumnInfo(name = "Product_status")
    var productStatus: Int,
    @ColumnInfo(name = "Product_balance")
    var productBalance: Int
    ) {
}