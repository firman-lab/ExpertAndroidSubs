package com.elpath.expertandroidsubs.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elpath.expertandroidsubs.core.data.source.remote.network.ApiService
import com.elpath.expertandroidsubs.core.data.source.remote.response.ApiResponse
import com.elpath.expertandroidsubs.core.data.source.remote.response.MovieResponse
import com.elpath.expertandroidsubs.core.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getMovieNowPlaying() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultsMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val response = apiService.getMovieList().await()
                resultsMovie.postValue(ApiResponse.success(response.results))
            }catch (e: IOException){
                e.printStackTrace()
                resultsMovie.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultsMovie
    }
}