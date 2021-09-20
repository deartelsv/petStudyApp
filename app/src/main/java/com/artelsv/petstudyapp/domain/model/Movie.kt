package com.artelsv.petstudyapp.domain.model

import com.artelsv.petstudyapp.R
import com.google.gson.annotations.SerializedName

const val IMAGE_URL = "https://www.themoviedb.org/t/p/original"

data class Movie(
    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    val budget: Int,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,

    //    @SerializedName("belongs_to_collection") val belongsToCollection: String? = null,
    //    val genres: List<Genre>,
    //    val homepage: String,
//    @SerializedName("imdb_id") val imdbId: String,
//    @SerializedName("production_companies") val productionCompanies: List<Company>,
//    @SerializedName("production_countries") val productionCountries: List<Country>,
    //    @SerializedName("spoken_languages") val spokenLanguages: List<Language>,
//    val status: String,
//    val tagline: String,

    val movieType: MovieType = MovieType.POPULAR
) {
    //TODO этого здес быть не должно, это уже относится к логике презентационного слоя (все 3 функции)
    fun getImageUrl() = IMAGE_URL + backdropPath
    fun getVoteAsString() = voteAverage.toString()
    fun getVoteColor() = when(voteAverage) {
        in 0.0..5.0 -> R.color.red
        in 5.1..7.0 -> R.color.yellow
        in 7.1..10.0 -> R.color.green
        else -> R.color.red
    }
}