package com.defey.testcourse.repository

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.api_service.CoursesApi
import com.defey.testcourse.dto.CourseDto
import com.defey.testcourse.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val coursesApi: CoursesApi,
) : CoursesRepository {

    override suspend fun getCourses(): NetworkResult<List<Course>> = withContext(Dispatchers.IO) {
        return@withContext try {
            NetworkResult.Success(coursesApi.getCourses().courses.map { it.toCourse() })
        } catch (e: Throwable) {
            NetworkResult.Error(e.message)
        }
    }

    fun CourseDto.toCourse(): Course =
        Course(
            id = this.id,
            title = this.title,
            text = this.text,
            price = this.price,
            rate = this.rate,
            startDate = this.startDate,
            hasLike = this.hasLike,
            publishDate = this.publishDate,
        )
}