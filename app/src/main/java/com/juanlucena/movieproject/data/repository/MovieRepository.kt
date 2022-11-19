package com.juanlucena.movieproject.data.repository

import com.juanlucena.movieproject.data.database.dao.MovieDao
import com.juanlucena.movieproject.data.database.entity.MovieEntity
import com.juanlucena.movieproject.data.model.MovieModel
import com.juanlucena.movieproject.data.network.MovieApiClient
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiClient: MovieApiClient,
    private val movieDao: MovieDao
) {

    suspend fun getAllMoviesFromApi(): List<MovieModel>{
        return apiClient.getAllMovies().body()!!
    }

    suspend fun getAllMoviesFromDatabase(): List<MovieEntity>{
        return movieDao.getAllMovies()
    }

    suspend fun insertAllMovies(movieEntityList: List<MovieEntity>){
        movieDao.insertAllMovies(movieEntityList)
    }
}