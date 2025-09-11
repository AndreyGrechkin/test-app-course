package com.defey.testcourse.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DaosModule::class])
object DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "courses-database",
    ).build()
}