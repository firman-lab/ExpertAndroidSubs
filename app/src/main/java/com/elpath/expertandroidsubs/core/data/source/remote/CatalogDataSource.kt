package com.elpath.expertandroidsubs.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.elpath.expertandroidsubs.core.data.source.local.MovieEntity
import com.elpath.jetpack_submission.vo.Resource

interface CatalogDataSource {

    fun getMovieNowPlaying() : LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId : Int) : LiveData<MovieEntity>

    fun setFavoriteMovie(movie : MovieEntity)

}