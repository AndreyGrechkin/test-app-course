package com.defey.testcourse.use_cases


interface DeleteCoursesUseCase {

    suspend operator fun invoke(id: Int)
}