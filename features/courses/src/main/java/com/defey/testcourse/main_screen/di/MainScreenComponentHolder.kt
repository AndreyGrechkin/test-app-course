package com.defey.testcourse.main_screen.di

import androidx.fragment.app.Fragment
import com.defey.testcourse.di.ComponentHolder
import com.defey.testcourse.di.findDependencies

class MainScreenComponentHolder : ComponentHolder<MainScreenComponent, Fragment>(
    creator = { fragment ->
        DaggerMainScreenComponent.factory()
            .create(fragment.findDependencies())
    }
)