package com.defey.testcourse.di

import com.defey.testcourse.flow.AuthFlowDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ComponentDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    fun bindMainDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AuthFlowDependencies::class)
    fun bindAuthFlowDependencies(appComponent: AppComponent): ComponentDependencies
}