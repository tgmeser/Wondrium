package com.babyapps.wondrium.data.repository

import com.babyapps.wondrium.data.api.WondriumApi
import javax.inject.Inject

class WondriumRepository @Inject constructor(private val wondriumApi: WondriumApi) {
    suspend fun getCourses() = wondriumApi.getCourses().products
}