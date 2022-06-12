package com.testapp.ecomerce.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testapp.ecomerce.databinding.RecyclerProductItemBinding
import com.testapp.ecomerce.models.Product

// Recycler view item click listener
typealias ItemClickListener = ((view: View, position: Int) -> Unit)?

class ProductsAdapter(
    private val viewModel: ProductsViewModel
) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var itemClickListener: ItemClickListener = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerProductItemBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = viewModel.getItemsCount()

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(viewModel.getItemAt(position))

    inner class ProductViewHolder(private val binding: RecyclerProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                invokeClickEvent(it)
            }
        }
        fun bind(item: Product?) {
            item?.let {
                binding.product = item
            }
        }

        private fun invokeClickEvent(view: View) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                itemClickListener?.invoke(view, adapterPosition)
            }
        }
    }


}