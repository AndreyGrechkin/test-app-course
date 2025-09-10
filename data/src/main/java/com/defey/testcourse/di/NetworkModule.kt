package com.defey.testcourse.di

import com.defey.testcourse.api_service.CoursesApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface NetworkModule {
    @Module
    companion object {
        @Provides
        fun provideBaseUrl(): String = "https://drive.usercontent.google.com/"

        @Provides
        fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        @Provides
        fun provideOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build()
                    chain.proceed(request)
                }
                .build()
        }

        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            baseUrl: String,
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        fun provideCoursesApi(retrofit: Retrofit): CoursesApi {
            return retrofit.create(CoursesApi::class.java)
        }
    }
}