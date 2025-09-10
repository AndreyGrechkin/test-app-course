package com.defey.testcourse.di

import com.defey.testcourse.flow.AuthFlowDependencies
import com.defey.testcourse.flow.di.CoursesFlowDependencies
import com.defey.testcourse.navigate.RootScreenRouterImpl
import com.defey.testcourse.navigation.RootScreenRouter
import com.defey.testcourse.repository.CoursesRepository
import com.defey.testcourse.repository.CoursesRepositoryImpl
import com.defey.testcourse.use_cases.GetCourseUseCase
import com.defey.testcourse.use_cases.GetCourseUseCaseImpl
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

    @Binds
    fun bindRootScreenRouter(impl: RootScreenRouterImpl): RootScreenRouter

    @Binds
    fun bindCourseRepository(impl: CoursesRepositoryImpl): CoursesRepository

    @Binds
    fun bindGetCourseUseCase(impl: GetCourseUseCaseImpl): GetCourseUseCase

}