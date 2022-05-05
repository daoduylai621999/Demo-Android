package com.example.recyclerview.ui.detail

import androidx.lifecycle.*
import com.example.recyclerview.models.MovieDetailModel
import com.example.recyclerview.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _movieDetail = MutableLiveData<MovieDetailModel>()

    val movieDetail : LiveData<MovieDetailModel> = Transformations.map(_movieDetail) {
        it
    }

    fun getMovieDetail(movieID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getMovieDetail(movieID = movieID).let {
                _movieDetail.postValue(it)
            }
        }
    }
}