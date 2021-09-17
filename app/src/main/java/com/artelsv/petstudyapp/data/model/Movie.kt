package com.artelsv.petstudyapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artelsv.petstudyapp.R
import com.google.gson.annotations.SerializedName

const val IMAGE_URL = "https://www.themoviedb.org/t/p/original"

@Entity(tableName = "movies")
data class Movie (
//    @PrimaryKey(autoGenerate = true)
//    val uid: Int,

    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
//    @SerializedName("belongs_to_collection") val belongsToCollection: String? = null,
    val budget: Int,
//    val genres: List<Genre>,
    @SerializedName("genre_ids") val genreIds: List<Int>,
//    val homepage: String,
    @PrimaryKey
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
) {
    fun getImageUrl() = IMAGE_URL + backdropPath
    fun getVoteAsString() = voteAverage.toString()
    fun getVoteColor() = when(voteAverage) {
        in 0.0..5.0 -> R.color.red
        in 5.1..7.0 -> R.color.yellow
        in 7.1..10.0 -> R.color.green
        else -> R.color.red
    }
}