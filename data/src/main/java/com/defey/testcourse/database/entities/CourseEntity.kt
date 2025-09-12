package com.defey.testcourse.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.defey.testcourse.database.LocalDateTypeConverter
import java.time.LocalDate

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    @TypeConverters(LocalDateTypeConverter::class)
    val startDate: LocalDate?,
    val hasLike: Boolean,
    @TypeConverters(LocalDateTypeConverter::class)
    val publishDate: LocalDate?,
)