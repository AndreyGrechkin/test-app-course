package com.defey.testcourse.adapter

import android.view.View
import android.view.ViewGroup
import androidx.collection.ArrayMap
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

class BindableRecyclerAdapter(
    private val factory: ArrayMap<KClass<out BindableRecyclerDisplayItem>, BindableViewHolderFactory<View, BindableRecyclerDisplayItem>>,
) : RecyclerView.Adapter<BindableViewHolder<BindableRecyclerDisplayItem, View>>() {

    var itemsList: List<BindableRecyclerDisplayItem> = listOf()
        private set

    override fun getItemCount(): Int = itemsList.size

    override fun getItemViewType(position: Int): Int {
        val bindingItem = itemsList.getOrNull(position) ?: return super.getItemViewType(position)

        return factory.indexOfKey(bindingItem::class)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BindableViewHolder<BindableRecyclerDisplayItem, View> =
        factory.valueAt(viewType).create(parent)

    fun setItems(diffResult: DiffUtil.DiffResult, items: List<BindableRecyclerDisplayItem>) {
        itemsList = items
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(
        holder: BindableViewHolder<BindableRecyclerDisplayItem, View>,
        position: Int,
    ) = Unit

    override fun onBindViewHolder(
        holder: BindableViewHolder<BindableRecyclerDisplayItem, View>,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        val model = itemsList.getOrNull(position) ?: return
        holder.item = model
        val factory = factory.getValue(model::class)
        factory.bind(holder.binding, model, payloads)
    }
}