package com.defey.testcourse.use_cases

import com.defey.testcourse.model.Course
import com.defey.testcourse.repository.CoursesDbRepository
import javax.inject.Inject

class UpsertCoursesUseCaseImpl @Inject constructor(
    private val repository: CoursesDbRepository,
) : UpsertCoursesUseCase {

    override suspend fun invoke(course: Course) {
        repository.setFavoriteCourse(course)
    }
}