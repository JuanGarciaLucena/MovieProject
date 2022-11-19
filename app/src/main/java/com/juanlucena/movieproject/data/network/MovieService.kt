package com.juanlucena.movieproject.data.network

import com.juanlucena.movieproject.data.model.MovieModel
import com.juanlucena.movieproject.data.network.MovieApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService(private val apiClient: MovieApiClient) {

    suspend fun getAllMovies(): List<MovieModel>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllMovies()
            response.body() ?: emptyList()
        }
    }
}