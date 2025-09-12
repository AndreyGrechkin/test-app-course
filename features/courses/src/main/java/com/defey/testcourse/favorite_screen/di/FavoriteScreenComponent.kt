package com.defey.testcourse.favorite_screen.di

import com.defey.testcourse.favorite_screen.ui.FavoriteScreenFragment
import dagger.Component

@Component(
    dependencies = [FavoriteScreenDependencies::class],
    modules = []
)
interface FavoriteScreenComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: FavoriteScreenDependencies): FavoriteScreenComponent
    }

    fun inject(fragment: FavoriteScreenFragment)
}