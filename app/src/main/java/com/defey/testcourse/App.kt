package com.defey.testcourse

import android.app.Application
import com.defey.testcourse.di.AppComponent
import com.defey.testcourse.di.ComponentDependenciesMap
import com.defey.testcourse.di.DaggerAppComponent
import com.defey.testcourse.di.HasComponentDependencies
import javax.inject.Inject

class App : Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesMap
    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()
        component.inject(this)
    }
}