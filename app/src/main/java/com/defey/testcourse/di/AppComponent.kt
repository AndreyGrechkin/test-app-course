package com.defey.testcourse.di

import android.app.Application
import com.defey.testcourse.App
import dagger.BindsInstance
import dagger.Component
import di.AuthModule
import di.DataModule
import di.MainModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        AuthModule::class,
        MainModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            appModule: AppModule
        ): AppComponent
    }
    fun inject(application: App)
}