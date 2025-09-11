package com.defey.testcourse.main_screen.ui

import com.defey.testcourse.adapter.BindableRecyclerDisplayItem
import java.time.LocalDate

data class CourseItemCellViewDisplayItem(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: LocalDate?,
) : BindableRecyclerDisplayItem