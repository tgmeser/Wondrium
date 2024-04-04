package com.babyapps.wondrium.injection

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WondriumApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}