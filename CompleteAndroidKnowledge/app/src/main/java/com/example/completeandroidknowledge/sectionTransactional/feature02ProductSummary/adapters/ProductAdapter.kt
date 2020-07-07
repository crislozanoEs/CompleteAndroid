package com.example.completeandroidknowledge.sectionTransactional.feature02ProductSummary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.completeandroidknowledge.databinding.ItemProductSummaryBinding
import com.example.completeandroidknowledge.sectionTransactional.model.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ViewHolder>(
    ProductDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(val binding: ItemProductSummaryBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Product){
            /** BEFORE BINDING ADAPTERS
             * binding.accountNumberText.text = item.idBankProduct
             * binding.accountBalanceText.text = item.productBalance.toString()
             * binding.accountNameText.text = item.productNumber*/
            binding.product = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductSummaryBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

    }

    class ProductDiffCallBack: DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.idProduct ==  newItem.idProduct
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}