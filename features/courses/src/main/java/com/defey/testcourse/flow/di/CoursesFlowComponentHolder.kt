package com.defey.testcourse.flow.di

import androidx.fragment.app.Fragment
import com.defey.testcourse.di.ComponentHolder
import com.defey.testcourse.di.findDependencies

class CoursesFlowComponentHolder : ComponentHolder<CoursesFlowComponent, Fragment>(
    creator = { fragment ->
        DaggerCoursesFlowComponent.factory()
            .create(fragment.findDependencies())
    }
)