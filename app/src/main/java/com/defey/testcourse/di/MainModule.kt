package com.defey.testcourse.di

import com.defey.testcourse.flow.AuthFlowDependencies
import com.defey.testcourse.flow.di.CoursesFlowDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AuthFlowDependencies::class)
    fun bindAuthFlowDependencies(appComponent: MainComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(CoursesFlowDependencies::class)
    fun bindCoursesFlowDependencies(appComponent: MainComponent): ComponentDependencies


}