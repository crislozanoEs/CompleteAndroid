package com.example.completeandroidknowledge.transtationalSection.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductSummaryDatabaseDao {
    @Insert
    fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllProducts(product: List<Product>)

    @Query("SELECT * FROM products_table WHERE idProduct = :id")
    fun get(id: Int) : LiveData<Product>

    @Query("SELECT * FROM products_table")
    fun getAllProducts() : LiveData<List<Product>>

    @Query("DELETE FROM products_table")
    fun clearProducts()


}