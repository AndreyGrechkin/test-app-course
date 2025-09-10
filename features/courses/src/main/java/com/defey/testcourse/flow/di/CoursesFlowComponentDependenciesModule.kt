package com.defey.testcourse.flow.di

import com.defey.testcourse.di.ComponentDependencies
import com.defey.testcourse.di.ComponentDependenciesKey
import com.defey.testcourse.favorite_screen.di.FavoriteScreenDependencies
import com.defey.testcourse.main_screen.di.MainScreenDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CoursesFlowComponentDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainScreenDependencies::class)
    fun bindMainScreenDependencies(component: CoursesFlowComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(FavoriteScreenDependencies::class)
    fun bindFavoriteScreenDependencies(component: CoursesFlowComponent): ComponentDependencies
}