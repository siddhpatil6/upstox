package com.upstox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.upstox.R
import com.upstox.data.CryptoItem
import com.upstox.data.FilterTypeItem
import com.upstox.databinding.FilterListItemBinding
import com.upstox.interfaces.OnItemClickListener

class TextAdapter(
    private val fiterOptionSet: List<FilterTypeItem>?,
    private val listener: OnItemClickListener) : RecyclerView.Adapter<TextAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FilterListItemBinding>(inflater, R.layout.filter_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fiterOptionSet?.get(position))
        holder.itemView.setOnClickListener {
            fiterOptionSet?.get(position)?.isSelected = fiterOptionSet?.get(position)?.isSelected?.not() ?:false
            notifyItemChanged(position)
            listener.onItemClick(fiterOptionSet)
        }
    }

    override fun getItemCount(): Int {
        return fiterOptionSet?.size?:0
    }

    class ViewHolder(var binding: FilterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FilterTypeItem?) {
            binding.filterListItem = item
            binding.executePendingBindings()
        }
    }
}
