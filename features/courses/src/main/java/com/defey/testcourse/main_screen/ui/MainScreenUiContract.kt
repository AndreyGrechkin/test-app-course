package com.defey.testcourse.main_screen.ui

class MainScreenUiContract {

    sealed class Event {
        data object OnSortedCourses : Event()
        data class OnFavorite(val id: Int) : Event()
    }

    data class State(
        val courses: List<CourseItemCellViewDisplayItem> = emptyList(),
    )
}