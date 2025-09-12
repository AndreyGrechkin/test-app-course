package com.defey.testcourse.main_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defey.testcourse.flow.ui.CourseItemCellViewDisplayItem
import com.defey.testcourse.flow.ui.toCourse
import com.defey.testcourse.flow.ui.toDisplayItem
import com.defey.testcourse.model.Course
import com.defey.testcourse.network.onError
import com.defey.testcourse.network.onSuccess
import com.defey.testcourse.use_cases.DeleteCoursesUseCase
import com.defey.testcourse.use_cases.GetCourseUseCase
import com.defey.testcourse.use_cases.UpsertCoursesUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel @Inject constructor(
    private val getCourseUseCase: GetCourseUseCase,
    private val deleteCoursesUseCase: DeleteCoursesUseCase,
    private val upsertCoursesUseCase: UpsertCoursesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MainScreenUiContract.State())
    val state get() = _state.asStateFlow()

    init {
        fetchInitData()
    }

    fun handleEvent(event: MainScreenUiContract.Event) {
        when (event) {
            is MainScreenUiContract.Event.OnFavorite -> {
                toggleHasLikeById(event.id)
            }

            MainScreenUiContract.Event.OnSortedCourses -> {
                val sortedList = state.value.courses.sortedByDescending { it.publishDate }
                _state.update { it.copy(courses = sortedList) }
            }
        }
    }

    private fun fetchInitData() {
        viewModelScope.launch {
            getCourseUseCase().onSuccess { response ->
                val displayItem = response.map { item ->
                    if (item.hasLike) saveFavoriteCourse(item)
                    item.toDisplayItem()
                }
                _state.update { it.copy(courses = displayItem) }
            }.onError {}
        }
    }

    private fun toggleHasLikeById(itemId: Int) {
        _state.update { currentState ->
            val updatedCourses = currentState.courses.map { course ->
                if (course.id == itemId) toggleCourseLike(course) else course
            }
            currentState.copy(courses = updatedCourses)
        }
    }

    private fun toggleCourseLike(course: CourseItemCellViewDisplayItem): CourseItemCellViewDisplayItem {
        val newHasLike = !course.hasLike
        val updatedCourse = course.copy(hasLike = newHasLike)

        if (newHasLike) {
            saveFavoriteCourse(updatedCourse.toCourse())
        } else {
            deleteFavoriteCourse(course.id)
        }
        return updatedCourse
    }

    private fun saveFavoriteCourse(course: Course) {
        viewModelScope.launch {
            upsertCoursesUseCase(course)
        }
    }

    private fun deleteFavoriteCourse(id: Int) {
        viewModelScope.launch {
            deleteCoursesUseCase(id)
        }
    }
}