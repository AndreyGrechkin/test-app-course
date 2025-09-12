package com.defey.testcourse.login.ui

class LoginUiContract {

    sealed class Event {
        data class UpdateEmail(val email: String? = null) : Event()
        data class UpdatePassword(val password: String? = null) : Event()
        data object OnCourses : Event()
        data object NavigateToVk : Event()
        data object NavigateToOk : Event()
    }

    data class State(
        val email: String? = null,
        val password: String? = null,
        val isLoginAvailable: Boolean = false,
    )
}