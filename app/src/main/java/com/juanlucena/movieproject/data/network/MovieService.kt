package com.juanlucena.movieproject.data.network

import com.juanlucena.movieproject.data.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val apiClient: MovieApiClient) {

    suspend fun getAllMovies(): List<MovieModel>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllMovies()
            response.body() ?: emptyList()
        }
    }
}