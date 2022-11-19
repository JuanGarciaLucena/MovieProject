package com.juanlucena.movieproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.juanlucena.movieproject.data.database.dao.MovieDao
import com.juanlucena.movieproject.data.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
}