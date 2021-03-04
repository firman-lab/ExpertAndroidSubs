package com.elpath.expertandroidsubs.core.utils

import com.elpath.expertandroidsubs.core.data.source.local.MovieEntity
import com.elpath.expertandroidsubs.core.domain.model.Movie

object DataMapper {
    fun mapEntitiesToDomain(input : List<MovieEntity>): List<Movie> = input.map {
        Movie(
            overview = it.overview,
            originalLanguage = it.originalLanguage,
            title = it.title,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath,
            releaseDate = it.releaseDate,
            isFavorite = it.isFavorite,
            movieId = it.movieId,
        )
    }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        isFavorite = input.isFavorite,
        movieId = input.movieId,
    )
}