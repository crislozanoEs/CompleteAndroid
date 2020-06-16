package com.example.completeandroidknowledge.commons

import android.content.Context
import com.example.completeandroidknowledge.R
import java.text.DecimalFormat

fun maskProductId(productId: String, context: Context) : String{
    val stringCut = productId.subSequence(productId.length-4, productId.length)
    return context.getString(R.string.maskedProductId, stringCut)
}

fun passStatusProduct(idStatus: Int, context: Context): String =
    when(idStatus){
    1 -> context.getString(R.string.status_activated)
    2 -> context.getString(R.string.status_blocked)
    3 -> context.getString(R.string.status_canceled)
    4 -> context.getString(R.string.status_default)
    5 -> context.getString(R.string.status_inactive)
    else -> "" }


fun castProductBalance(productBalance: Double, context: Context): String{
    val format = DecimalFormat(context.getString(R.string.format_balance))
    val balanceString = format.format(productBalance)
    return context.getString(R.string.product_balance_format, balanceString)
}