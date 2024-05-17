package com.upstox.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.upstox.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("isActive", "type")
    fun setImageResource(view: ImageView, isActive: Boolean, type: String?) {
        val resource = when {
            isActive && type == "coin" -> R.drawable.coin_active
            isActive && type == "token" -> R.drawable.token_active
            !isActive -> R.drawable.inactive
            else -> 0 // Or some default image resource
        }
        if (resource != 0) {
            view.setImageResource(resource)
        }
    }

    @JvmStatic
    @BindingAdapter("isVisible")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
