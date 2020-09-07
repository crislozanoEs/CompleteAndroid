package com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogEvent
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CustomImageAnalyzer

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory (private val customImageAnalyzer: CustomImageAnalyzer, private val dialogEventBus: DialogEventBus, private val dialogManager: DialogManager) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(
                customImageAnalyzer,
                dialogManager,
                dialogEventBus
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}