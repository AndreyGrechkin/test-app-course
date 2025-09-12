package com.defey.testcourse.use_cases

import com.defey.testcourse.model.Course

interface UpsertCoursesUseCase {
    suspend operator fun invoke(course: Course)
}