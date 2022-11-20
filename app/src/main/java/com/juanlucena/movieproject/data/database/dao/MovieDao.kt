package com.juanlucena.movieproject.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juanlucena.movieproject.data.database.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movieEntityList: List<MovieEntity>)

    @Delete
    suspend fun deleteMovieFromDatabase(movie: MovieEntity)

    @Query("UPDATE movie_table SET title = :title, description = :description WHERE id = :movieId")
    suspend fun editMovie(movieId: String, title: String, description: String)
}