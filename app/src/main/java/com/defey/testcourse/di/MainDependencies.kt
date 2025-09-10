package com.defey.testcourse.di

import com.defey.testcourse.api_service.CoursesApi
import com.defey.testcourse.navigation.AppRootRouter
import com.github.terrakok.cicerone.NavigatorHolder

interface MainDependencies : ComponentDependencies {
    val navigationHolder: NavigatorHolder
    val router: AppRootRouter
    val coursesApi: CoursesApi
}