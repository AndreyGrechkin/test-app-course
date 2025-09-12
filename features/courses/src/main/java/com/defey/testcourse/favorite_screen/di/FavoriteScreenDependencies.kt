package com.defey.testcourse.favorite_screen.di

import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.ComponentDependencies

interface FavoriteScreenDependencies : ComponentDependencies {
    val factory: ViewModelProvider.Factory
}