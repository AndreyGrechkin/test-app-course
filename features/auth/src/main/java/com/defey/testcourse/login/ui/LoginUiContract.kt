package com.defey.testcourse.login.ui

class LoginUiContract {

    sealed class Event{

        data object OnCourses: Event()
    }
}