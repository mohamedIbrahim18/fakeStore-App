package com.example.fakestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.products.Products
import com.example.fakestore.databinding.ItemProductsBinding

class ProductsAdapter (var listOfProducts:List<Products?>?): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    class ViewHolder(var itemBinding : ItemProductsBinding):RecyclerView.ViewHolder(
        itemBinding.root
    ){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfProducts?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = listOfProducts?.get(position)
        holder.itemBinding.nameLineTitle.text=product?.title
        holder.itemBinding.priceLineProduct.text = product?.price.toString()
        holder.itemBinding.categoryLineProduct.text = product?.category
        Glide.with(holder.itemView)
            .load(product?.image)
            .into(holder.itemBinding.imageProduct)

        holder.itemBinding.root.setOnClickListener {
            onItemClickedListnner?.onItemClick(position,product!!)
        }
    }

    fun changeToNewProducts(it: List<Products?>) {
        listOfProducts= it
        notifyDataSetChanged()
    }
    var onItemClickedListnner : OnItemClickListener?=null
   fun interface OnItemClickListener {
        fun onItemClick(position: Int, task: Products)
    }
}