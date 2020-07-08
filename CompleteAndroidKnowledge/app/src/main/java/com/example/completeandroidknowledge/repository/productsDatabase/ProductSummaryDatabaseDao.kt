package com.example.completeandroidknowledge.repository.productsDatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductSummaryDatabaseDao {
    @Insert
    fun insert(product: ProductTable)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllProducts(product: List<ProductTable>)

    @Query("SELECT * FROM products_table WHERE product_id_bank = :productId")
    fun get(productId: String) : LiveData<ProductTable>

    @Query("SELECT * FROM products_table")
    fun getAllProducts() : LiveData<List<ProductTable>>

    @Query("DELETE FROM products_table")
    fun clearProducts()


}