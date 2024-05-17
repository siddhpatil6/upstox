package com.upstox.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.upstox.R
import com.upstox.adapter.TextAdapter
import com.upstox.data.FilterTypeItem
import com.upstox.interfaces.BottomSheetListener
import com.upstox.interfaces.OnItemClickListener
import com.upstox.utils.Constants

class FilterBottomSheet : BottomSheetDialogFragment() , OnItemClickListener {

    val fiterOptionSet = listOf(
        FilterTypeItem(true,Constants.ACTIVE_COINS),
        FilterTypeItem(true,Constants.INACTIVE_COINS),
        FilterTypeItem(true,Constants.ONLY_TOKENS),
        FilterTypeItem(true,Constants.ONLY_COINS),
        FilterTypeItem(true,Constants.NEW_COINS))

    private var listener: BottomSheetListener? = null

    fun setBottomSheetListener(listener: BottomSheetListener) {
        this.listener = listener
    }

    companion object {
        fun newInstance(): FilterBottomSheet {
            return FilterBottomSheet()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.filter_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = TextAdapter(fiterOptionSet,this)
    }

    override fun onItemClick(fiterOptionSet: List<FilterTypeItem>?) {
        listener?.onActionSelected(this.fiterOptionSet)
    }
}