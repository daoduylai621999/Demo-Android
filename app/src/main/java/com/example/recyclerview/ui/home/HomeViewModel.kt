package com.example.recyclerview.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.recyclerview.models.BaseResponse
import com.example.recyclerview.models.PopularModel
import com.example.recyclerview.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _popularList = MutableLiveData<BaseResponse<List<PopularModel>>>()

    val popularList: LiveData<BaseResponse<List<PopularModel>>> =
        Transformations.map(_popularList) {
            it
        }

    init {
        getPopular()
    }

    private fun getPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getPopular().let {
                _popularList.postValue(it)
            }
        }
    }
}