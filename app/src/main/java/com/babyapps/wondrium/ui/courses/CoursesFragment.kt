package com.babyapps.wondrium.ui.courses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.babyapps.wondrium.R
import com.babyapps.wondrium.databinding.FragmentCoursesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CoursesFragment : Fragment(R.layout.fragment_courses) {


    private lateinit var binding: FragmentCoursesBinding

    private lateinit var coursesAdapter: CoursesAdapter
    private val viewModel: CoursesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCoursesBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        subscribeObservers()
        coursesAdapter.setOnItemClickListener {


            findNavController().navigate(
                R.id.action_coursesFragment_to_lectureFragment,
                null
            )
        }
    }

    private fun subscribeObservers() {
            viewModel.fetchData()
            viewModel.courses.observe(viewLifecycleOwner, Observer {
                coursesAdapter.differ.submitList(it)
            })
    }

    private fun setRecyclerView() {
        binding.apply {
            recyclerView.apply {
                coursesAdapter = CoursesAdapter()
                adapter = coursesAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
                setHasFixedSize(true)
            }
        }
    }
}