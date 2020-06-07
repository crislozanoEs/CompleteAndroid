package com.example.completeandroidknowledge.section2.uiControllers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.ProductSummaryFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.UserViewModel
import com.example.completeandroidknowledge.section2.model.ProductSummaryDatabase
import com.example.completeandroidknowledge.section2.model.temporalModels.ProductSummaryClassT
import com.example.completeandroidknowledge.section2.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.section2.viewModel.ProductSummaryViewModelFactory

class ProductSummaryFragment: Fragment() {

    private lateinit var binding: ProductSummaryFragmentBinding
    private lateinit var viewModelFactory: ProductSummaryViewModelFactory
    private lateinit var viewModel: ProductSummaryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_summary_fragment, container, false)
        // binding.user = user
        val application = requireNotNull(this.activity).application
        val dataSource = ProductSummaryDatabase.getInstance(application).productSummaryDatabaseDao
        viewModelFactory = ProductSummaryViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductSummaryViewModel::class.java)
        temporalInitProductSummary()
        //val dataSource = UserDatabase.getInstance(application).userDatabaseDao
        return binding.root
    }

    private fun temporalInitProductSummary(){
        viewModel.temporalInitProductSummary()
    }

}