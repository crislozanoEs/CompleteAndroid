package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

@BindingAdapter("setTexProduct")
fun TextView.setTexProduct(item: BankProduct?){
    item?.let{
        text = "${item.textProduct} \n ${item.urlProduct}"
    }
}

@BindingAdapter("setBankProductImage")
fun ImageView.setBankProductImage(item: BankProduct?){
    item?.let{
        when(it.imageId){
            1 -> setImageResource(R.drawable.bp_1)
            2 -> setImageResource(R.drawable.bp_2)
            3 -> setImageResource(R.drawable.bp_3)
            else -> setImageResource(R.drawable.bp_1)
        }


    }
}

