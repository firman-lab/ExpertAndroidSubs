package com.elpath.expertandroidsubs.core.data.source.remote.network

import com.elpath.expertandroidsubs.BuildConfig
import com.elpath.expertandroidsubs.core.data.source.remote.response.MovieResponse
import com.elpath.expertandroidsubs.core.data.source.remote.response.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getMovieList(
        @Query("api_key") api_key : String = BuildConfig.TMDB_API_KEY
    ): Call<Response<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId : Int,
        @Query("api_key") api_key : String = BuildConfig.TMDB_API_KEY
    ): Call<MovieResponse>

}