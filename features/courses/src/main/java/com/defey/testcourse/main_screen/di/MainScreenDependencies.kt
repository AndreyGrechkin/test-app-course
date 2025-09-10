package com.defey.testcourse.main_screen.di

import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.ComponentDependencies


interface MainScreenDependencies: ComponentDependencies {
    val factory: ViewModelProvider.Factory

}