package com.defey.testcourse.use_cases

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.model.Course
import com.defey.testcourse.repository.CoursesRepository
import javax.inject.Inject

class GetCourseUseCaseImpl @Inject constructor(
    private val repository: CoursesRepository,
) : GetCourseUseCase {
    override suspend fun invoke(): NetworkResult<List<Course>> {
        return repository.getCourses()
    }
}