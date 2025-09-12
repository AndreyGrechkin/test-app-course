package com.defey.testcourse.di

import com.defey.testcourse.flow.AuthFlowDependencies
import com.defey.testcourse.flow.di.CoursesFlowDependencies
import com.defey.testcourse.navigate.RootScreenRouterImpl
import com.defey.testcourse.navigation.RootScreenRouter
import com.defey.testcourse.repository.CoursesApiRepository
import com.defey.testcourse.repository.CoursesApiRepositoryImpl
import com.defey.testcourse.repository.CoursesDbRepository
import com.defey.testcourse.repository.CoursesDbRepositoryImpl
import com.defey.testcourse.use_cases.DeleteCoursesUseCase
import com.defey.testcourse.use_cases.DeleteCoursesUseCaseImpl
import com.defey.testcourse.use_cases.GetCourseUseCase
import com.defey.testcourse.use_cases.GetCourseUseCaseImpl
import com.defey.testcourse.use_cases.GetFlowCoursesUseCase
import com.defey.testcourse.use_cases.GetFlowCoursesUseCaseImpl
import com.defey.testcourse.use_cases.UpsertCoursesUseCase
import com.defey.testcourse.use_cases.UpsertCoursesUseCaseImpl
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
    fun bindCourseApiRepository(impl: CoursesApiRepositoryImpl): CoursesApiRepository

    @Binds
    fun bindGetCourseUseCase(impl: GetCourseUseCaseImpl): GetCourseUseCase

    @Binds
    fun bindCourseDbRepository(impl: CoursesDbRepositoryImpl): CoursesDbRepository

    @Binds
    fun bindDeleteCoursesUseCase(impl: DeleteCoursesUseCaseImpl): DeleteCoursesUseCase

    @Binds
    fun bindGetFlowCoursesUseCase(impl: GetFlowCoursesUseCaseImpl): GetFlowCoursesUseCase

    @Binds
    fun bindUpsertCoursesUseCase(impl: UpsertCoursesUseCaseImpl): UpsertCoursesUseCase

}