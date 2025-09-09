package com.defey.testcourse.login.di

import androidx.fragment.app.Fragment
import com.defey.testcourse.di.ComponentHolder
import com.defey.testcourse.di.findDependencies

class LoginComponentHolder : ComponentHolder<LoginComponent, Fragment>(
    creator = { fragment ->
        DaggerLoginComponent.factory()
            .create(fragment.findDependencies())
    }
)
