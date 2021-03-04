package com.elpath.expertandroidsubs.core.data.source.local

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "favorite_movie")
@Parcelize
data class MovieEntity (
    @ColumnInfo(name = "overview")
    var overview : String?,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage : String?,

    @ColumnInfo(name = "title")
    var title : String?,

    @ColumnInfo(name = "posterPath")
    var posterPath : String?,

    @ColumnInfo(name = "backdropPath")
    var backdropPath : String?,

    @ColumnInfo(name = "releaseDate")
    var releaseDate : String?,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false,

    @PrimaryKey()
    @ColumnInfo(name = "movieId")
    var movieId : Int? = null
): Parcelable