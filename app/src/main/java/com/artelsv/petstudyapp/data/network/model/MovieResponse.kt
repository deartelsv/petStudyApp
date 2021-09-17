package com.artelsv.petstudyapp.data.network.model

import com.artelsv.petstudyapp.data.model.Movie

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)