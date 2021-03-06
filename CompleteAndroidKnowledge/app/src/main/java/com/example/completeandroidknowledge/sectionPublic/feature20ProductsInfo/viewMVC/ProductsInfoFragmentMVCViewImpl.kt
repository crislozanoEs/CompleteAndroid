package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewMVC

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.ProductInfoBinding
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.adapters.BankProductAdapter
import com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.viewModel.ProductsInfoViewModel
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

class ProductsInfoFragmentMVCViewImpl(layoutInflater: LayoutInflater, val parent: ViewGroup?) : ProductsInfoFragmentMVCView,
    ObservableViewMVCImpl<ProductsInfoFragmentMVCView.Listener, ProductInfoBinding>(){

    private lateinit var bankProductsAdapter: BankProductAdapter

    override val binding: ProductInfoBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_info, parent, false)

    init {
        setRootView(binding.root)
    }
    override fun setViewModel(viewModel: ProductsInfoViewModel) {
        binding.bankProducts = viewModel
    }

    override fun setAdapterBankProducts() {
        bankProductsAdapter = BankProductAdapter(BankProductAdapter.OnClickListener{
            notifyBankProductClicked()
        })
        binding.productsInfoList.adapter = bankProductsAdapter
    }

    override fun showLoading(showLoading: Boolean){
        if(showLoading)
            binding.loadingProgress.visibility = View.VISIBLE
        else
            binding.loadingProgress.visibility = View.GONE
    }

    override fun showError() {
        binding.productsInfoList.visibility = View.GONE
        binding.errorProductsInfo.visibility = View.VISIBLE
        binding.txtError.text = parent!!.context.getString(R.string.generic_error)
    }

    override fun setListBankProducts(bankProducts: List<BankProduct>) {
        bankProductsAdapter.submitList(bankProducts)
    }

    private fun notifyBankProductClicked() {
        getListener().forEach {
            it.onBankProductClicked()
        }
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }


}