package com.defey.testcourse.main_screen.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defey.testcourse.network.onError
import com.defey.testcourse.network.onSuccess
import com.defey.testcourse.use_cases.GetCourseUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.launch

class MainScreenViewModel @Inject constructor(
    private val getCourseUseCase: GetCourseUseCase,
) : ViewModel() {

    init {
        Log.d("MyLog", "init vm")
//        fetchInitData()
    }

    fun fetchInitData() {
        viewModelScope.launch {
            getCourseUseCase().onSuccess { response ->
                Log.d("MyLog", "response: ${response}")
            }.onError {
                Log.d("MyLog", "err")
            }
        }
    }
}