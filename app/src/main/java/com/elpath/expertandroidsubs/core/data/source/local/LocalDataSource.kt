package com.elpath.expertandroidsubs.core.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.elpath.expertandroidsubs.core.data.source.local.room.CatalogDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val catalogDao: CatalogDao){

    fun getAllMovies() : DataSource.Factory<Int, MovieEntity> = catalogDao.getListMovie()

    fun getFavoritesMovie() : DataSource.Factory<Int, MovieEntity> = catalogDao.getFavoriteMovieList()

    fun getMovieDetail(movieId : Int) : LiveData<MovieEntity> = catalogDao.getMovieDetail(movieId)

    fun insertMovie(movie : List<MovieEntity>) = catalogDao.insertMovies(movie)

    fun setFavoriteMovie(movie : MovieEntity){
        movie.isFavorite = !movie.isFavorite
        catalogDao.updateMovie(movie)
    }
}