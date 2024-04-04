package com.babyapps.wondrium.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babyapps.wondrium.R
import com.babyapps.wondrium.ui.courses.CoursesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // If savedInstanceState is null, meaning the activity is created for the first time
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CoursesFragment())
                .commit()
        }
    }
}