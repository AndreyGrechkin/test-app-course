package com.defey.testcourse.login.ui

import androidx.lifecycle.ViewModel
import com.defey.testcourse.navigation.FlowRouter
import com.defey.testcourse.navigation.RootScreen
import com.defey.testcourse.navigation.RootScreenRouter
import jakarta.inject.Inject

class LoginViewModel @Inject constructor(
    private val router: FlowRouter,
//    private val rootScreenRouter: RootScreenRouter
): ViewModel() {

    init {

    }

    fun handleEvent(event: LoginUiContract.Event){
        when (event){
            LoginUiContract.Event.OnCourses -> router.navigateNewRootScreen(RootScreen.COURSES_SCREEN)
        }
    }
}