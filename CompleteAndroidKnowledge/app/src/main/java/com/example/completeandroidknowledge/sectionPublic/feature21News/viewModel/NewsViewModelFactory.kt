package com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CustomImageAnalyzer

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory (private val customImageAnalyzer: CustomImageAnalyzer) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(
                customImageAnalyzer
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}