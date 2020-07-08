package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.adapters.adaptersUtils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.completeandroidknowledge.commons.castProductBalance
import com.example.completeandroidknowledge.commons.maskProductId
import com.example.completeandroidknowledge.commons.passStatusProduct
import com.example.completeandroidknowledge.sectionTransactional.model.Product

@BindingAdapter("productNumberCast")
fun TextView.setProductNumberCasted(item: Product?){
    item?.let {
        text = maskProductId(
            item.productBankId,
            context
        )
    }
}

@BindingAdapter("productStatusCast")
fun TextView.setStatusCast(item: Product?){
    item?.let {
        text = passStatusProduct(
            item.productStatus,
            context
        )
    }
}

@BindingAdapter("productBalanceCast")
fun TextView.setProductBalanceCast(item: Product?){
    item?.let {
        text = castProductBalance(
            item.productBalance,
            context
        )
    }
}