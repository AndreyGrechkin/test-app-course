package com.defey.testcourse.favorite_screen.ui

import com.defey.testcourse.flow.ui.CourseItemCellViewDisplayItem

class FavoriteScreenUiContract {

    sealed class Event {
        data class OnDeleteFavorite(val id: Int) : Event()
    }

    data class State(
        val courses: List<CourseItemCellViewDisplayItem> = emptyList(),
    )
}