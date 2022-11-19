package com.juanlucena.movieproject.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.juanlucena.movieproject.data.database.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieEntity>
}