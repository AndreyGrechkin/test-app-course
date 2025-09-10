package com.defey.testcourse.api_service

import com.defey.testcourse.dto.CoursesResponseDto
import retrofit2.http.GET

interface CoursesApi {

    @GET("uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): CoursesResponseDto
}