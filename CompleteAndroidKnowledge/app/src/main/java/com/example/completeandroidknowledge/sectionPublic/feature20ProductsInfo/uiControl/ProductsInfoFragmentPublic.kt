package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC.ProductsInfoFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

class ProductsInfoFragmentPublic : BaseFragmentPublic(), NavigationActivity.Listener {

    private lateinit var productsInfoFragmentMVCViewImpl: ProductsInfoFragmentMVCView
    private lateinit var viewModel: ProductsInfoViewModel
    private lateinit var navigation: Navigation
    private lateinit var navigationActivity: NavigationActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productsInfoFragmentMVCViewImpl = getCompositionRootObject().getViewMVCFactory().getProductsInfoFragmentMVCView(container)
        navigationActivity = getCompositionRootObject().getMainNavigation()
        viewModel = ViewModelProvider(this).get(ProductsInfoViewModel::class.java)
        productsInfoFragmentMVCViewImpl.setViewModel(viewModel)
        productsInfoFragmentMVCViewImpl.setAdapterBankProducts()
        var bankProduct = BankProduct(1,1,"ESTE TEXTO DE PRUEBA","http://google.com", false)
        var bankProduct1 = BankProduct(2,1,"ESTE TEXTO DE PRUEBA 2","http://wikipedia.com", false)
        var bankProductList = listOf<BankProduct>(bankProduct, bankProduct1)
        productsInfoFragmentMVCViewImpl.setListBankProducts(bankProductList)
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
