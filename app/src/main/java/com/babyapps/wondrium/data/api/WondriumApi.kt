package com.babyapps.wondrium.data.api

import com.babyapps.wondrium.data.model.Course
import com.babyapps.wondrium.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface WondriumApi {

    @GET("/homeitems")
    suspend fun getCourses(): Course

}