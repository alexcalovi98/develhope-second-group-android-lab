package com.android.lab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lab.databinding.ItemBinding

class ListAdapter(private val items: List<ItemData>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var counter: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        counter++
        return ViewHolder(itemBinding, counter)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemBinding, private val viewNumber: Int) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.icon.setImageResource(item.icon)
            binding.text.text = itemView.context.getString(item.text) + " (View number" + viewNumber + ")"
        }
    }
}