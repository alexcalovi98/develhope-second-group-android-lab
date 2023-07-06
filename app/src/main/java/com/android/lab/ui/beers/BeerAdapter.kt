package com.android.lab.ui.beers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.disk.DiskCache
import coil.load
import coil.memory.MemoryCache
import com.android.lab.databinding.ItemBinding

class BeerAdapter(private val items: MutableList<BeerItem> = mutableListOf()) : RecyclerView.Adapter<BeerAdapter.ViewHolder>() {

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

    fun addItems(items : List<BeerItem>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemBinding, private val viewNumber: Int) : RecyclerView.ViewHolder(binding.root) {

        private val imageLoader = ImageLoader.Builder(itemView.context)
            .memoryCache {
                MemoryCache.Builder(itemView.context)
                    .maxSizePercent(0.25)
                    .build()
            }.diskCache {
                DiskCache.Builder()
                    .directory(itemView.context.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.02)
                    .build()
            }.respectCacheHeaders(false)
            .build()

        fun bind(item: BeerItem) {
            binding.icon.load(item.image, imageLoader)
            binding.text.text = item.name
        }
    }
}