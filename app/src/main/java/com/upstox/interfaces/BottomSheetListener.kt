package com.upstox.interfaces

import com.upstox.data.FilterTypeItem

interface BottomSheetListener {
        fun onActionSelected(fiterOptionSet: List<FilterTypeItem>?)
    }