package com.defey.testcourse.main_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defey.testcourse.network.onError
import com.defey.testcourse.network.onSuccess
import com.defey.testcourse.use_cases.GetCourseUseCase
import com.defey.testcourse.utils.formatDateToString
import com.defey.testcourse.utils.formatPriceClean
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel @Inject constructor(
    private val getCourseUseCase: GetCourseUseCase,
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
                    CourseItemCellViewDisplayItem(
                        id = item.id,
                        title = item.title,
                        text = item.text,
                        price = formatPriceClean(item.price),
                        rate = item.rate,
                        startDate = formatDateToString(item.startDate),
                        hasLike = item.hasLike,
                        publishDate = item.publishDate
                    )
                }
                _state.update { it.copy(courses = displayItem) }
            }.onError {}
        }
    }

    fun toggleHasLikeById(itemId: Int) {
        val newList = state.value.courses.map { item ->
            if (item.id == itemId) item.copy(hasLike = !item.hasLike)
            else item
        }
        _state.update { it.copy(courses = newList) }
    }
}