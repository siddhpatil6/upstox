package com.upstox.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoItem(
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val symbol: String,
    val type: String
):Parcelable