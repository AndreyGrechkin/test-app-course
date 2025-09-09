package com.defey.testcourse.di

import com.defey.testcourse.MainActivity
import com.defey.testcourse.flow.AuthFlowDependencies
import dagger.Component

@Component(
    modules = [MainModule::class],
    dependencies = [MainDependencies::class]
)
interface MainComponent : AuthFlowDependencies {

    @Component.Factory
    interface Factory {
        fun create(mainDependencies: MainDependencies): MainComponent
    }

    fun inject(activity: MainActivity)
}