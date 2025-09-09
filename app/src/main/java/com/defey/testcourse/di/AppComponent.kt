package com.defey.testcourse.di

import android.content.Context
import com.defey.testcourse.App
import com.defey.testcourse.flow.AuthFlowDependencies
import dagger.BindsInstance
import dagger.Component
import di.MainModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ComponentDependenciesModule::class,
        DataModule::class,
        MainModule::class,
        NavigationModule::class,
    ]
)
interface AppComponent :  MainDependencies {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}