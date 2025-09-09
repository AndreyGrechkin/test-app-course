package com.defey.testcourse.di

import com.defey.testcourse.flow.AuthFlowDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AuthFlowDependencies::class)
    fun bindAuthFlowDependencies(appComponent: MainComponent): ComponentDependencies
}