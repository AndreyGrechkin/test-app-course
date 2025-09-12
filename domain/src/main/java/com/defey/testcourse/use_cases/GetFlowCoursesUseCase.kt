package com.defey.testcourse.use_cases

import com.defey.testcourse.model.Course
import kotlinx.coroutines.flow.Flow

interface GetFlowCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}