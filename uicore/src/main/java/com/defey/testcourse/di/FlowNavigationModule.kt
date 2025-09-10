package com.defey.testcourse.di

import com.defey.testcourse.navigation.AppFlowRouter
import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.FlowRouter
import com.defey.testcourse.navigation.RootScreenRouter
import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides

@Module
class FlowNavigationModule {

    @FlowScope
    @Provides
    fun provideCicerone(
        appRouter: AppRootRouter,
        rootScreenRouter: RootScreenRouter
        ) = Cicerone.create(AppFlowRouter(appRouter, rootScreenRouter))

    @FlowScope
    @Provides
    fun provideRouter(cicerone: Cicerone<AppFlowRouter>): FlowRouter = cicerone.router

    @FlowScope
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<AppFlowRouter>) = cicerone.getNavigatorHolder()
}