package com.defey.testcourse

import android.app.Application
import com.defey.testcourse.di.AppComponent
import com.defey.testcourse.di.AppModule
import com.defey.testcourse.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        // Создаем экземпляр AppModule
        val appModule = AppModule(this)

        // Инициализация Dagger компонента с передачей AppModule
        appComponent = DaggerAppComponent.factory()
            .create(this, appModule)

        appComponent.inject(this)
    }
}