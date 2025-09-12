package com.defey.testcourse.use_cases

import com.defey.testcourse.model.Course
import com.defey.testcourse.repository.CoursesDbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFlowCoursesUseCaseImpl @Inject constructor(
    private val repository: CoursesDbRepository,
) : GetFlowCoursesUseCase {

    override fun invoke(): Flow<List<Course>> {
        return repository.observeFavoriteCourses()
    }
}