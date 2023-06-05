package com.example.empower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.empower.databinding.ItemBinding


class CartAdapter(
    var items: List<Cart>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    inner class CartViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = items[position]
        val binding = ItemBinding.bind(holder.itemView)

        binding.tvTitle.text = currentItem.title
        binding.tvPrice.text = currentItem.price.toString()
        binding.cbDone.isChecked = currentItem.isChecked

    }

}