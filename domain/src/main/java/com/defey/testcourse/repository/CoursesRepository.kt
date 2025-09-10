package com.defey.testcourse.repository

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.model.Course

interface CoursesRepository {
    suspend fun getCourses(): NetworkResult<List<Course>>
}