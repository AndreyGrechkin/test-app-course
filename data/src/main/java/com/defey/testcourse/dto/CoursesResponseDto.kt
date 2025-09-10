package com.defey.testcourse.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoursesResponseDto(
    val courses: List<CourseDto>,
)
