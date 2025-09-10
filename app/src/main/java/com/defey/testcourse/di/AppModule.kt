package com.defey.testcourse.di

import com.defey.testcourse.navigate.RootScreenRouterImpl
import com.defey.testcourse.navigation.RootScreenRouter
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun bindRootScreenRouter(impl: RootScreenRouterImpl): RootScreenRouter
}