package com.defey.testcourse.flow

import androidx.fragment.app.Fragment
import com.defey.testcourse.di.ComponentHolder
import com.defey.testcourse.di.findDependencies


class AuthFlowComponentHolder : ComponentHolder<AuthFlowComponent, Fragment>(
    creator = { fragment ->
        DaggerAuthFlowComponent.factory()
            .create(fragment.findDependencies())
    }
)

