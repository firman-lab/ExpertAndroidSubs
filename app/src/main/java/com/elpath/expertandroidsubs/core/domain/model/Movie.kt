package com.elpath.expertandroidsubs.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val overview : String?,

    val originalLanguage : String?,

    val title : String?,

    val posterPath : String?,

    val backdropPath : String?,

    val releaseDate : String?,

    val isFavorite : Boolean = false,

    val movieId : Int? = null
) : Parcelable