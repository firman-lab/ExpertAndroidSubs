package com.elpath.expertandroidsubs.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.elpath.expertandroidsubs.core.data.source.local.MovieEntity

@Dao
interface CatalogDao {
    @Query("SELECT * FROM favorite_movie")
    fun getListMovie() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM favorite_movie WHERE id = :movieId")
    fun getMovieDetail(movieId : Int) : LiveData<MovieEntity>

    @Query("SELECT * FROM favorite_movie WHERE isFavorite = 1")
    fun getFavoriteMovieList() : DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovies(movie : List<MovieEntity>)

    @Update(entity = MovieEntity::class)
    fun updateMovie(movie : MovieEntity)

}