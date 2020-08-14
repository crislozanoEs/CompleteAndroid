package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.sectionPublic.PublicActivity
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC.ProductsInfoFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModelFactory
import com.example.completeandroidknowledge.sectionTransactional.MainActivity
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.STATE

class ProductsInfoFragmentPublic : BaseFragmentPublic(), NavigationActivity.Listener {

    private lateinit var productsInfoFragmentMVCViewImpl: ProductsInfoFragmentMVCView
    private lateinit var viewModel: ProductsInfoViewModel
    private lateinit var viewModelFactory: ProductsInfoViewModelFactory
    private lateinit var navigation: Navigation
    private lateinit var navigationActivity: NavigationActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productsInfoFragmentMVCViewImpl = getCompositionRootObject().getViewMVCFactory().getProductsInfoFragmentMVCView(container)
        navigationActivity = getCompositionRootObject().getMainNavigation()
        viewModelFactory = ProductsInfoViewModelFactory(getCompositionRootObject().getProductsInfoUseCase())
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductsInfoViewModel::class.java)
        productsInfoFragmentMVCViewImpl.setViewModel(viewModel)
        productsInfoFragmentMVCViewImpl.setAdapterBankProducts()
        viewModel.products.observe(viewLifecycleOwner, Observer {
            it?.let {
                productsInfoFragmentMVCViewImpl.setListBankProducts(it)
            }
        })
        viewModel.currentState.observe(viewLifecycleOwner, Observer {
            val showLoading = when(it){
                STATE.LOADING -> true
                STATE.PRODUCTS_INFO_SUCCEED -> false
                STATE.PRODUCTS_INFO_FAILED -> false
                else -> false
            }
            val activity = getCompositionRootObject().getActivity() as PublicActivity
            // Put this logic here, so the MVCView does not know about the activity dependency needed
            if(showLoading)
                activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            else
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            if(it == STATE.PRODUCTS_INFO_FAILED)
                productsInfoFragmentMVCViewImpl.showError()
            productsInfoFragmentMVCViewImpl.showLoading(showLoading)
        })
        return productsInfoFragmentMVCViewImpl.getRootView()
    }

    override fun onStart() {
        navigationActivity.registerListener(this)
        super.onStart()
    }

    override fun onStop() {
        navigationActivity.unregisterListener(this)
        super.onStop()
    }

    override fun onHomeClicked() {
        navigationActivity.fromProductsIntoToHome()
    }

    override fun onProductsInfoClicked() {
        //Not need to move
    }

    override fun onNewsClicked() {
        navigationActivity.fromProductsInfoToNews()
    }
}
