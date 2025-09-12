package com.defey.testcourse.use_cases

import com.defey.testcourse.repository.CoursesDbRepository
import javax.inject.Inject

class DeleteCoursesUseCaseImpl @Inject constructor(
    private val repository: CoursesDbRepository,
) : DeleteCoursesUseCase {

    override suspend fun invoke(id: Int) {
        repository.deleteFavoriteCourse(id)
    }
}