package com.defey.testcourse.di

import com.defey.testcourse.navigation.AppRootRouter
import com.github.terrakok.cicerone.NavigatorHolder

interface MainDependencies : ComponentDependencies {
    val navigationHolder: NavigatorHolder
    val router: AppRootRouter
}