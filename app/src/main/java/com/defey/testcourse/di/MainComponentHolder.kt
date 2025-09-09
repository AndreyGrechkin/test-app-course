package com.defey.testcourse.di

import android.app.Activity

internal class MainComponentHolder : ComponentHolder<MainComponent, Activity>(
    creator = { activity ->
        DaggerMainComponent.factory()
            .create(
                activity.findDependencies(),
            )
    }
)