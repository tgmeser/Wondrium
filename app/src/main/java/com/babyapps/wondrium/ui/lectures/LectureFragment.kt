package com.babyapps.wondrium.ui.lectures

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.babyapps.wondrium.R
import com.babyapps.wondrium.databinding.FragmentLectureBinding
import com.babyapps.wondrium.ui.player.ExoPlayerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LectureFragment : Fragment(R.layout.fragment_lecture) {

    private lateinit var binding: FragmentLectureBinding
    private lateinit var lecturesAdapter: LectureAdapter
    private val viewModel: LecturesViewModel by viewModels()

    val videoUrl1 =
        "https://cdn.flowplayer.com/a30bd6bc-f98b-47bc-abf5-97633d4faea0/hls/ de3f6ca7-\n" +
                "2db3-4689-8160-0f574a5996ad/playlist.m3u8"
    val videoUrl2 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/\n" +
            "BigBuckBunny.mp4"
    val videoUrl3 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/\n" +
            "ForBiggerBlazes.mp4"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLectureBinding.bind(view)

        setRecyclerView()
        subscribeObservers()
        lecturesAdapter.setOnItemClickListener {

            val intent = Intent(requireContext(), ExoPlayerActivity::class.java)
            intent.putExtra("VIDEO_URL_TO_PLAY_1", videoUrl1)
            intent.putExtra("VIDEO_URL_TO_PLAY_2", videoUrl2)
            intent.putExtra("VIDEO_URL_TO_PLAY_3", videoUrl3)
            startActivity(intent)

        }

    }

    private fun subscribeObservers() {
        viewModel.fetchData()

        viewModel.productDetail.observe(viewLifecycleOwner, Observer {
            binding.tvProfName.text = "Professor :  ${it.course_professor_name}  (${it.course_professor_qualification})"
            binding.tvCourseName.text = "Course : ${it.course_name}"
            binding.tvCourseDesc.text = "Description : ${it.course_description}"
            binding.tvInsTitle.text = "Instructor Title : ${it.instructor_title}"
            lecturesAdapter.differ.submitList(it.lectures)
        })
    }

    private fun setRecyclerView() {
        binding.apply {
            recyclerView.apply {
                lecturesAdapter = LectureAdapter()
                adapter = lecturesAdapter
                layoutManager = LinearLayoutManager(requireContext())
                recyclerView.isNestedScrollingEnabled = false
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
                setHasFixedSize(false)
            }
        }
    }

}