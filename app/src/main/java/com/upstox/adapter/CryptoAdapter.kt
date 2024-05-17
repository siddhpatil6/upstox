package com.upstox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upstox.R
import com.upstox.data.CryptoItem
import com.upstox.databinding.CryptoItemBinding


class CryptoAdapter : ListAdapter<CryptoItem, CryptoAdapter.UpstoxViewHolder>(DiffCallback) {

    inner class UpstoxViewHolder(var binding: CryptoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CryptoItem) {
            binding.cryptoItem = item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpstoxViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CryptoItemBinding>(inflater, R.layout.crypto_item, parent, false)
        return UpstoxViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpstoxViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CryptoItem>() {
            override fun areItemsTheSame(
                oldItem: CryptoItem,
                newItem: CryptoItem
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: CryptoItem,
                newItem: CryptoItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
