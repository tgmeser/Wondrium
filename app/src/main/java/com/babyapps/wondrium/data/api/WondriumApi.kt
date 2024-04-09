package com.babyapps.wondrium.data.api

import com.babyapps.wondrium.data.model.course.Course
import com.babyapps.wondrium.data.model.lecture.ProductDetail
import retrofit2.http.GET

interface WondriumApi {

    @GET("/homeitems")
    suspend fun getCourses(): Course

    @GET("/details")
    suspend fun getLectures(): ProductDetail

}