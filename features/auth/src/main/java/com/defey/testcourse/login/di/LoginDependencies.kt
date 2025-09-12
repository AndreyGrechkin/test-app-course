package com.defey.testcourse.login.di

import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.ComponentDependencies

interface LoginDependencies : ComponentDependencies {
    val factory: ViewModelProvider.Factory
}