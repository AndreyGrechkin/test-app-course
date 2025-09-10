package com.defey.testcourse.main_screen.di

import com.defey.testcourse.main_screen.ui.MainScreenFragment
import dagger.Component

@Component(
    dependencies = [MainScreenDependencies::class],
    modules = [MainScreenModule::class]
)
interface MainScreenComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: MainScreenDependencies): MainScreenComponent
    }

    fun inject(fragment: MainScreenFragment)
}