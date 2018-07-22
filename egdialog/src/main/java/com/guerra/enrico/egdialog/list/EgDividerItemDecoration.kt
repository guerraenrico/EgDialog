package com.guerra.enrico.egdialog.list

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by enrico
 * on 15/07/2018.
 */
class EgDividerItemDecoration(context: Context, orientation: Int): DividerItemDecoration(context, orientation) {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val pos = parent.getChildAdapterPosition(view)
        val adapter = parent.adapter
        if (adapter != null && pos == (adapter.itemCount  - 1)) {
            outRect.set(0,0,0,0)
        } else {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }
}