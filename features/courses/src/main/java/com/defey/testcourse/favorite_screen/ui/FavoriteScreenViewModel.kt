package com.defey.testcourse.favorite_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defey.testcourse.flow.ui.toDisplayItem
import com.defey.testcourse.use_cases.DeleteCoursesUseCase
import com.defey.testcourse.use_cases.GetFlowCoursesUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteScreenViewModel @Inject constructor(
    private val getFlowCoursesUseCase: GetFlowCoursesUseCase,
    private val deleteCoursesUseCase: DeleteCoursesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteScreenUiContract.State())
    val state get() = _state.asStateFlow()

    init {
        observeCourses()
    }

    fun handleEvent(event: FavoriteScreenUiContract.Event) {
        when (event) {
            is FavoriteScreenUiContract.Event.OnDeleteFavorite -> {
                deleteFavoriteCourse(event.id)
            }
        }
    }

    private fun observeCourses() {
        getFlowCoursesUseCase().onEach { response ->
            val displayItem = response.map { item ->
                item.toDisplayItem()
            }
            _state.update { it.copy(courses = displayItem) }
        }.launchIn(viewModelScope)
    }

    private fun deleteFavoriteCourse(itemId: Int) {
        viewModelScope.launch {
            state.value.courses.map { item ->
                if (item.id == itemId) {
                    deleteCoursesUseCase(itemId)
                }
            }
        }
    }
}