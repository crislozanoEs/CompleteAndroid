package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentTransactional
import com.example.completeandroidknowledge.sectionPublic.PublicActivity
import com.example.completeandroidknowledge.sectionPublic.feature01User.viewModel.UserViewModel
import com.example.completeandroidknowledge.sectionTransactional.MainActivity
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCView
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewMVC.ProductSummaryFragmentMVCViewImpl
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModel
import com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.viewModel.ProductSummaryViewModelFactory

class ProductSummaryFragmentPublic: BaseFragmentTransactional() {

    private lateinit var productSummaryFragmentMVCViewImpl: ProductSummaryFragmentMVCViewImpl
    private lateinit var viewModelFactory: ProductSummaryViewModelFactory
    private lateinit var viewModel: ProductSummaryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productSummaryFragmentMVCViewImpl = getCompositionRootObject().getViewMVCFactory().getProductSummaryFragmentMVCView(container)
        val application = requireNotNull(this.activity).application
        viewModelFactory = ProductSummaryViewModelFactory(
            getCompositionRootObject().getProductSummaryUseCaseImpl(application),
            getCompositionRootObject().getProductServiceUseCase(),
            application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductSummaryViewModel::class.java)
        productSummaryFragmentMVCViewImpl.setViewModel(viewModel)
        productSummaryFragmentMVCViewImpl.setAdapterProductSummary()
        viewModel.productSummary.observe(viewLifecycleOwner,  Observer {
            it?.let{
                productSummaryFragmentMVCViewImpl.setListDataToAdapter(it)
            }
        })

        viewModel.currentState.observe(viewLifecycleOwner, Observer {
            val showLoading = when(it){
                ProductSummaryViewModel.STATE.LOADING -> true
                ProductSummaryViewModel.STATE.PRODUCT_SUMMARY_SUCCEED -> false
                ProductSummaryViewModel.STATE.PRODUCT_SUMMARY_FAILED -> false
                else -> false
            }
            val activity = getCompositionRootObject().getActivity() as MainActivity
            // Put this logic here, so the MVCView does not know about the activity dependency needed
            if(showLoading)
                activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            else
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            productSummaryFragmentMVCViewImpl.showLoading(showLoading)
        })
        viewModel.startGettingProductSummary()
        return productSummaryFragmentMVCViewImpl.getRootView()
    }
}
