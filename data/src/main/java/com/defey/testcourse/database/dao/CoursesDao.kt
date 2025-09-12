package com.defey.testcourse.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.defey.testcourse.database.entities.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoursesDao {

    @Upsert
    suspend fun upsertCourse(course: CourseEntity)

    @Query(value = "DELETE FROM course WHERE id = :id")
    suspend fun deleteCourseWithId(id: Int)


    @Query(value = "SELECT * FROM course")
    fun getCourses(): Flow<List<CourseEntity>>
}