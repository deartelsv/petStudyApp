package com.artelsv.petstudyapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artelsv.petstudyapp.R
import com.artelsv.petstudyapp.domain.model.Language
import com.artelsv.petstudyapp.domain.model.MovieType
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieEntity (
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
//    @SerializedName("belongs_to_collection") val belongsToCollection: String? = null,
    val budget: Int,
//    val genres: List<Genre>,
    val genreIds: List<Int>,
//    val homepage: String,
//    @SerializedName("imdb_id") val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
//    @SerializedName("production_companies") val productionCompanies: List<Company>,
//    @SerializedName("production_countries") val productionCountries: List<Country>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
//    @SerializedName("spoken_languages") val spokenLanguages: List<Language>,
//    val status: String,
//    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,

    val movieType: MovieType
)