package com.defey.testcourse.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BindableViewHolder<M : BindableRecyclerDisplayItem, out B : View>(val binding: B) :
    RecyclerView.ViewHolder(binding) {

    lateinit var item: M
}