package com.defey.testcourse.repository

import com.defey.testcourse.model.Course
import kotlinx.coroutines.flow.Flow

interface CoursesDbRepository {
    suspend fun setFavoriteCourse(course: Course)
    suspend fun deleteFavoriteCourse(id: Int)
    fun observeFavoriteCourses(): Flow<List<Course>>
}