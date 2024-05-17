package com.upstox.interfaces

import com.upstox.data.FilterTypeItem

interface OnItemClickListener {
    fun onItemClick(fiterOptionSet: List<FilterTypeItem>?)
}