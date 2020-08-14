package com.example.completeandroidknowledge.sectionPublic.feature20ProductsInfo.adapters

import android.graphics.Matrix
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.completeandroidknowledge.databinding.ItemBankProductBinding
import com.example.completeandroidknowledge.sectionPublic.model.BankProduct

class BankProductAdapter(private val onClickListener: OnClickListener):
    ListAdapter<BankProduct, BankProductAdapter.ViewHolder>(BankProductDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent, onClickListener)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.itemView.setOnClickListener {
            openBankProductDetail(product, position)
        }
        holder.binding.moreButton.setOnClickListener {
            openBankProductDetail(product, position)
        }
        holder.bind(getItem(position))
    }


    private fun openBankProductDetail(product: BankProduct, position: Int){
        product.isOpen = !product.isOpen
        notifyItemChanged(position)
    }
    class ViewHolder(val binding: ItemBankProductBinding, val onClickListener: OnClickListener): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BankProduct){
            binding.bankProduct = item
            if(item.isOpen){
                binding.moreButton.visibility = View.GONE
                binding.expandedDetailProduct.visibility = View.VISIBLE
            }else{
                binding.moreButton.visibility = View.VISIBLE
                binding.expandedDetailProduct.visibility = View.GONE
            }
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent:ViewGroup, onClickListener: OnClickListener): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBankProductBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, onClickListener)
            }
        }
    }

    class OnClickListener(val clickListener: (bankProduct: BankProduct)-> Unit){
        fun onClick(product: BankProduct) = clickListener(product)
    }

    class BankProductDiffCallBack: DiffUtil.ItemCallback<BankProduct>(){
        override fun areItemsTheSame(oldItem: BankProduct, newItem: BankProduct): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BankProduct, newItem: BankProduct): Boolean {
            return oldItem == newItem
        }

    }

}