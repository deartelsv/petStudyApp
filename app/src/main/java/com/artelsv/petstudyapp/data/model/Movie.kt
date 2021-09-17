package com.artelsv.petstudyapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
//    @SerializedName("belongs_to_collection") val belongsToCollection: String? = null,
    val budget: Int,
//    val genres: List<Genre>,
    @SerializedName("genre_ids") val genreIds: List<Int>,
//    val homepage: String,
    val id: Int,
//    @SerializedName("imdb_id") val imdbId: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
//    @SerializedName("production_companies") val productionCompanies: List<Company>,
//    @SerializedName("production_countries") val productionCountries: List<Country>,
    @SerializedName("release_date") val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
//    @SerializedName("spoken_languages") val spokenLanguages: List<Language>,
//    val status: String,
//    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)