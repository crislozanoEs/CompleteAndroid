package com.example.completeandroidknowledge.section2.uiControllers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.ProductSummaryFragmentBinding

class ProductSummaryFragment: Fragment() {

    private lateinit var binding: ProductSummaryFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_summary_fragment, container, false)
        // binding.user = user

        val application = requireNotNull(this.activity).application
        //val dataSource = UserDatabase.getInstance(application).userDatabaseDao
        return binding.root
    }

}