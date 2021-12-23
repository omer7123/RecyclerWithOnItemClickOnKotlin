package com.ripalay.recyclerwithonitemclickonkotlin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.recyclerwithonitemclickonkotlin.databinding.ItemListBinding

class MainAdapter(private val list: ArrayList<Int>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(image: Int) {
            binding.imagesIv.setImageResource(image)
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }

    }

}