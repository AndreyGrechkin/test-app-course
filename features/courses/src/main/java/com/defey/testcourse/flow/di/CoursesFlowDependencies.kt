package com.defey.testcourse.flow.di

import com.defey.testcourse.di.ComponentDependencies
import com.defey.testcourse.flows.CommonFlowDependencies
import com.defey.testcourse.use_cases.GetCourseUseCase

interface CoursesFlowDependencies : ComponentDependencies, CommonFlowDependencies {
    val getCourseUseCase: GetCourseUseCase

}