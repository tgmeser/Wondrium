package com.babyapps.wondrium.data.repository

import com.babyapps.wondrium.data.api.WondriumApi
import com.babyapps.wondrium.data.model.course.Product
import com.babyapps.wondrium.data.model.lecture.Lecture
import com.babyapps.wondrium.data.model.lecture.ProductDetail
import javax.inject.Inject

class WondriumRepository @Inject constructor(private val wondriumApi: WondriumApi) {
    suspend fun getCourses():List<Product> = wondriumApi.getCourses().products
    suspend fun getLectures(): ProductDetail = wondriumApi.getLectures()
}