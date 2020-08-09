package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.completeandroidknowledge.databinding.ItemProductSummaryBinding
import com.example.completeandroidknowledge.sectionTransactional.model.Product

class ProductAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ProductDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent, onClickListener)



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.itemView.setOnClickListener {
            product.isOpened =  !product.isOpened
            notifyItemChanged(position)
        }
        holder.binding.productDetailButton.setOnClickListener{
            onClickListener.onClick(product)
        }
        holder.bind(getItem(position))
    }


    class ViewHolder(val binding: ItemProductSummaryBinding, val onClickListener: OnClickListener): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Product){
            /** BEFORE BINDING ADAPTERS
             * binding.accountNumberText.text = item.idBankProduct
             * binding.accountBalanceText.text = item.productBalance.toString()
             * binding.accountNameText.text = item.productNumber*/
            binding.product = item
            if(item.isOpened)
                binding.expandedDetailProduct.visibility = View.VISIBLE
            else
               binding.expandedDetailProduct.visibility = View.GONE
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup, onClickListener: OnClickListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductSummaryBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, onClickListener)
            }
        }
    }

    class OnClickListener(val clickListener: (product: Product) -> Unit) {
        fun onClick(product: Product) = clickListener(product)
    }

    class ProductDiffCallBack: DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.productBankId ==  newItem.productBankId
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}