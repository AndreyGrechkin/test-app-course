package com.defey.testcourse.main_screen.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.defey.testcourse.courses.R


class CourseItemCellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val titleTextView: AppCompatTextView
        get() = findViewById(R.id.title_text_view)
    private val descriptionTextView: AppCompatTextView
        get() = findViewById(R.id.description_text_view)
    private val dateTextView: AppCompatTextView
        get() = findViewById(R.id.date_text_view)
    private val rateTextView: AppCompatTextView
        get() = findViewById(R.id.rate_text_view)
    private val priceTextView: AppCompatTextView
        get() = findViewById(R.id.price_text_view)

    private val favoriteButton: AppCompatImageButton
        get() = findViewById(R.id.favorite_button)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_course_item, this, true)
    }

    fun configureWith(item: CourseItemCellViewDisplayItem) {
        titleTextView.text = item.title
        descriptionTextView.text = item.text
        dateTextView.text = item.startDate
        rateTextView.text = item.rate
        priceTextView.text = item.price
        favoriteButton.setImageResource(
            if (item.hasLike) com.defey.testcourse.uicore.R.drawable.ic_bookmark_fill
            else com.defey.testcourse.uicore.R.drawable.ic_bookmark_outline
        )
    }

    fun favoriteClickListener(listener: OnClickListener) {
        favoriteButton.setOnClickListener(listener)
    }
}