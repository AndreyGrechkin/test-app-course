package com.defey.testcourse.di

import android.content.Context
import com.defey.testcourse.App
import com.defey.testcourse.database.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ComponentDependenciesModule::class,
        NetworkModule::class,
        NavigationModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : MainDependencies {

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