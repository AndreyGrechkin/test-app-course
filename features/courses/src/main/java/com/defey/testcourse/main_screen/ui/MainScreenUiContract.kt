package com.defey.testcourse.main_screen.ui

import com.defey.testcourse.flow.ui.CourseItemCellViewDisplayItem

class MainScreenUiContract {

    sealed class Event {
        data object OnSortedCourses : Event()
        data class OnFavorite(val id: Int) : Event()
    }

    data class State(
        val courses: List<CourseItemCellViewDisplayItem> = emptyList(),
    )
}