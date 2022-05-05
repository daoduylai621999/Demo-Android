package com.example.recyclerview.repository

import com.example.recyclerview.data.remote.MovieApi
import com.example.recyclerview.models.BaseResponse
import com.example.recyclerview.models.MovieDetailModel
import com.example.recyclerview.models.PopularModel

abstract class MovieRepository {
    abstract suspend fun getPopular() : BaseResponse<List<PopularModel>>
    abstract suspend fun getMovieDetail(movieID : Int) : MovieDetailModel
}

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository() {
    override suspend fun getPopular(): BaseResponse<List<PopularModel>> {
        return movieApi.getPopularApi()
    }

    override suspend fun getMovieDetail(movieID : Int): MovieDetailModel {
        return movieApi.getMovieDetailApi(movieID = movieID)
    }

}