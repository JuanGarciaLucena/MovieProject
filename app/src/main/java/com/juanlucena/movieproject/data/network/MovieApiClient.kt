package com.juanlucena.movieproject.data.network

import com.juanlucena.movieproject.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {

    @GET("films")
    suspend fun getAllMovies() : Response<List<MovieModel>>
}