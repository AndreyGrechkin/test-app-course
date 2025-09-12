package com.defey.testcourse.flow.ui

import com.defey.testcourse.adapter.BindableRecyclerDisplayItem
import com.defey.testcourse.model.Course
import com.defey.testcourse.utils.formatDateToString
import com.defey.testcourse.utils.formatPriceClean
import com.defey.testcourse.utils.onlyDigits
import java.time.LocalDate

data class CourseItemCellViewDisplayItem(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: LocalDate?,
    val displayStartDate: String,
    val hasLike: Boolean,
    val publishDate: LocalDate?,
) : BindableRecyclerDisplayItem

fun CourseItemCellViewDisplayItem.toCourse(): Course =
    Course(
        id = this.id,
        title = this.title,
        text = this.text,
        price = this.price.onlyDigits(),
        rate = this.rate,
        startDate = this.startDate,
        hasLike = this.hasLike,
        publishDate = this.publishDate
    )

fun Course.toDisplayItem(): CourseItemCellViewDisplayItem =
    CourseItemCellViewDisplayItem(
        id = this.id,
        title = this.title,
        text = this.text,
        price = formatPriceClean(this.price),
        rate = this.rate,
        displayStartDate = formatDateToString(this.startDate),
        startDate = this.startDate,
        hasLike = this.hasLike,
        publishDate = this.publishDate
    )