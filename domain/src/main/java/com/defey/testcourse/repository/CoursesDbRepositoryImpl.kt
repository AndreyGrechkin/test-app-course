package com.defey.testcourse.repository

import com.defey.testcourse.database.dao.CoursesDao
import com.defey.testcourse.database.entities.CourseEntity
import com.defey.testcourse.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoursesDbRepositoryImpl @Inject constructor(
    private val dao: CoursesDao,
) : CoursesDbRepository {

    override suspend fun setFavoriteCourse(course: Course) = with(Dispatchers.IO) {
        dao.upsertCourse(course.toCourseEntity())
    }

    override suspend fun deleteFavoriteCourse(id: Int) = with(Dispatchers.IO) {
        dao.deleteCourseWithId(id)
    }

    override fun observeFavoriteCourses(): Flow<List<Course>> {
        return dao.getCourses().map {
            it.map { courseEntity ->
                courseEntity.toCourse()
            }
        }
    }

    fun CourseEntity.toCourse(): Course =
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

    fun Course.toCourseEntity(): CourseEntity =
        CourseEntity(
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