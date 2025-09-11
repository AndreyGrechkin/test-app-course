package com.defey.testcourse.adapter

import androidx.recyclerview.widget.DiffUtil

class BindableDiffUtilsCallback(
    private val oldItems: List<BindableRecyclerDisplayItem>,
    private val newItems: List<BindableRecyclerDisplayItem>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].areItemsTheSame(newItems[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].areContentsTheSame(newItems[newItemPosition])
    }
}