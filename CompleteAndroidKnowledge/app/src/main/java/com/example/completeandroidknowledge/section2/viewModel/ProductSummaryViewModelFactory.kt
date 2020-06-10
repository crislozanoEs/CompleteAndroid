package com.example.completeandroidknowledge.section2.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.section2.model.ProductSummaryDatabaseDao

class ProductSummaryViewModelFactory(private val productSummaryDatabaseDao: ProductSummaryDatabaseDao, private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductSummaryViewModel::class.java)) {
            return ProductSummaryViewModel(productSummaryDatabaseDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}