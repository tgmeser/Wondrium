package com.babyapps.wondrium.ui.course_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babyapps.wondrium.R
import com.babyapps.wondrium.databinding.FragmentCourseDetailBinding
import com.babyapps.wondrium.databinding.FragmentCoursesBinding


class CourseDetailFragment : Fragment(R.layout.fragment_course_detail) {


    private lateinit var binding: FragmentCourseDetailBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCourseDetailBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

    }

}