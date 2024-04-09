package com.babyapps.wondrium.ui.lectures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babyapps.wondrium.data.model.lecture.Lecture
import com.babyapps.wondrium.data.model.lecture.ProductDetail
import com.babyapps.wondrium.data.repository.WondriumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LecturesViewModel @Inject constructor(private val repository: WondriumRepository) :
    ViewModel() {

    private val _lectures = MutableLiveData<List<Lecture>>()
    val lectures: LiveData<List<Lecture>>
        get() = _lectures

    private val _productDetail = MutableLiveData<ProductDetail>()
    val productDetail: LiveData<ProductDetail>
        get() = _productDetail

    fun fetchData() {
        viewModelScope.launch {

           // _lectures.value = repository.getLectures().lectures
            _productDetail.value = repository.getLectures()
        }
    }

}