package com.example.completeandroidknowledge.section2.uiControllers.adapters.adaptersUtils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.completeandroidknowledge.castProductBalance
import com.example.completeandroidknowledge.maskProductId
import com.example.completeandroidknowledge.passStatusProduct
import com.example.completeandroidknowledge.section2.model.Product

@BindingAdapter("productNumberCast")
fun TextView.setProductNumberCasted(item: Product?){
    item?.let {
        text = maskProductId(item.idBankProduct, context)
    }
}

@BindingAdapter("productStatusCast")
fun TextView.setStatusCast(item: Product?){
    item?.let {
        text = passStatusProduct(item.productStatus, context)
    }
}

@BindingAdapter("productBalanceCast")
fun TextView.setProductBalanceCast(item: Product?){
    item?.let {
        text = castProductBalance(item.productBalance, context)
    }
}