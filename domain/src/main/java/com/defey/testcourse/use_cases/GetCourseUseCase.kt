package com.defey.testcourse.use_cases

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.model.Course

interface GetCourseUseCase {
    suspend operator fun invoke(): NetworkResult<List<Course>>
}