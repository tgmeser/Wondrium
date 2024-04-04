package com.babyapps.wondrium.ui.courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babyapps.wondrium.data.model.Course
import com.babyapps.wondrium.data.model.Product
import com.babyapps.wondrium.data.repository.WondriumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoursesViewModel @Inject constructor(private val repository: WondriumRepository): ViewModel() {

    private val _courses = MutableLiveData<List<Product>>()
    val courses: LiveData<List<Product>>
        get() = _courses

    fun fetchData(){
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }
}