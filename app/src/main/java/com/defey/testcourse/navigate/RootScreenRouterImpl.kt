package com.defey.testcourse.navigate

import com.defey.testcourse.flow.AuthFlowFragment
import com.defey.testcourse.flow.ui.CoursesFlowFragment
import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.RootScreen
import com.defey.testcourse.navigation.RootScreenRouter
import jakarta.inject.Inject

class RootScreenRouterImpl @Inject constructor(
    private val router: AppRootRouter,
) : RootScreenRouter {

    override fun navigateNewRootScreen(screen: RootScreen) {
        when (screen) {
            RootScreen.AUTH_SCREEN -> router.newRootScreen(AuthFlowFragment.newInstance())
            RootScreen.COURSES_SCREEN -> router.newRootScreen(CoursesFlowFragment.newInstance())
        }
    }
}