package com.defey.testcourse.flow.di

import com.defey.testcourse.di.ComponentDependencies
import com.defey.testcourse.flows.CommonFlowDependencies
import com.defey.testcourse.use_cases.DeleteCoursesUseCase
import com.defey.testcourse.use_cases.GetCourseUseCase
import com.defey.testcourse.use_cases.GetFlowCoursesUseCase
import com.defey.testcourse.use_cases.UpsertCoursesUseCase

interface CoursesFlowDependencies : ComponentDependencies, CommonFlowDependencies {
    val getCourseUseCase: GetCourseUseCase
    val getFlowCoursesUseCase: GetFlowCoursesUseCase
    val deleteCoursesUseCase: DeleteCoursesUseCase
    val upsertCoursesUseCase: UpsertCoursesUseCase
}