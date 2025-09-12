package com.defey.testcourse.repository

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.model.Course

interface CoursesApiRepository {
    suspend fun getCourses(): NetworkResult<List<Course>>
}