package com.defey.testcourse.database

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DaosModule {

    @Singleton
    @Provides
    fun provideCoursesDao(database: AppDatabase) = database.coursesDao()

}