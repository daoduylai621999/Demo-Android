package com.example.recyclerview.data.remote

import com.example.recyclerview.common.StringConstant
import com.example.recyclerview.models.BaseResponse
import com.example.recyclerview.models.MovieDetailModel
import com.example.recyclerview.models.PopularModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularApi(
        @Query("api_key") apiKey: String = StringConstant.API_KEY,
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1",
    ): BaseResponse<List<PopularModel>>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailApi(
        @Path("movie_id") movieID: Int,
        @Query("api_key") apiKey: String = StringConstant.API_KEY,
        @Query("language") language: String = "en-US",
    ): MovieDetailModel
}