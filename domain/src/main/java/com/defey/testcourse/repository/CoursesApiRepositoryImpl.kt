package com.defey.testcourse.repository

import com.defey.testcourse.network.NetworkResult
import com.defey.testcourse.api_service.CoursesApi
import com.defey.testcourse.dto.CourseDto
import com.defey.testcourse.model.Course
import com.defey.testcourse.utils.parseDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoursesApiRepositoryImpl @Inject constructor(
    private val coursesApi: CoursesApi,
) : CoursesApiRepository {

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
            startDate = parseDate(this.startDate) ,
            hasLike = this.hasLike,
            publishDate = parseDate(this.publishDate),
        )
}