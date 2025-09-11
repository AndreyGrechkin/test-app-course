package com.defey.testcourse.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.defey.testcourse.database.dao.CoursesDao
import com.defey.testcourse.database.entities.CourseEntity

@Database(
    entities = [CourseEntity::class],
    version = 1,
    autoMigrations = [],
    exportSchema = true
)
@TypeConverters(
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
}