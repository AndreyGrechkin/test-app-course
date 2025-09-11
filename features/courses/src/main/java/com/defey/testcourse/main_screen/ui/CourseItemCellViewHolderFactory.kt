package com.defey.testcourse.main_screen.ui

import android.view.ViewGroup
import android.widget.FrameLayout
import com.defey.testcourse.adapter.BindableViewHolder
import com.defey.testcourse.adapter.BindableViewHolderFactory

class CourseItemCellViewHolderFactory(
    private val onFavoriteClick: (id: Int) -> Unit,
) : BindableViewHolderFactory<CourseItemCellView, CourseItemCellViewDisplayItem> {

    override fun create(parent: ViewGroup): BindableViewHolder<CourseItemCellViewDisplayItem, CourseItemCellView> {
        return BindableViewHolder(
            binding = CourseItemCellView(parent.context).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            }
        )
    }

    override fun bind(
        binding: CourseItemCellView,
        model: CourseItemCellViewDisplayItem,
        payloads: List<Any>,
    ) {
        binding.configureWith(model)
        binding.favoriteClickListener { onFavoriteClick(model.id) }
    }
}