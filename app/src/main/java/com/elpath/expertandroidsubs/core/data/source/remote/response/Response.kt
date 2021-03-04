package com.elpath.expertandroidsubs.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @field:SerializedName("results")
    val results: List<T>
)

data class MovieResponse (
    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("id")
    val id: Int
)