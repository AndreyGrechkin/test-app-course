package com.defey.testcourse.adapter

import android.view.View
import android.view.ViewGroup

interface BindableViewHolderFactory<B : View, M : BindableRecyclerDisplayItem> {
    fun create(parent: ViewGroup): BindableViewHolder<M, B>
    fun bind(binding: B, model: M, payloads: List<Any>) = Unit
}