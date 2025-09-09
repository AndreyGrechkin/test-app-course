package com.defey.testcourse.di

import com.defey.testcourse.navigation.AppRootRouter
import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideCicerone() = Cicerone.create(AppRootRouter())

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<AppRootRouter>) = cicerone.router

    @Singleton
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<AppRootRouter>) = cicerone.getNavigatorHolder()

}