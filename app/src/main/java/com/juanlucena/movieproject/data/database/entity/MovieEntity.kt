package com.juanlucena.movieproject.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juanlucena.movieproject.data.model.MovieModel
import com.juanlucena.movieproject.domain.model.Movie


@Entity(tableName = "movie_table")
data class MovieEntity (

    @PrimaryKey
    @ColumnInfo(name = "id") val id : String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "originalTitle") val originalTitle : String,
    @ColumnInfo(name = "originalTitleRomanised") val originalTitleRomanised : String,
    @ColumnInfo(name = "image") val image : String,
    @ColumnInfo(name = "movieBanner") val movieBanner : String,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "director") val director : String,
    @ColumnInfo(name = "producer") val producer : String,
    @ColumnInfo(name = "releaseDate") val releaseDate : Int,
    @ColumnInfo(name = "runningTime") val runningTime : Int,
    @ColumnInfo(name = "rtScore") val rtScore : Int,
    @ColumnInfo(name = "people") val people : List<String>,
    @ColumnInfo(name = "species") val species : List<String>,
    @ColumnInfo(name = "locations") val locations : List<String>,
    @ColumnInfo(name = "vehicles") val vehicles : List<String>,
    @ColumnInfo(name = "url") val url : String
)

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        originalTitle = originalTitle,
        originalTitleRomanised = originalTitleRomanised,
        image = image,
        movieBanner = movieBanner,
        description = description,
        director = director,
        producer = producer,
        releaseDate = releaseDate,
        runningTime = runningTime,
        rtScore = rtScore,
        people = people,
        species = species,
        locations = locations,
        vehicles = vehicles,
        url = url,
    )
}

fun MovieModel.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        originalTitle = originalTitle,
        originalTitleRomanised = originalTitleRomanised,
        image = image,
        movieBanner = movieBanner,
        description = description,
        director = director,
        producer = producer,
        releaseDate = releaseDate,
        runningTime = runningTime,
        rtScore = rtScore,
        people = people,
        species = species,
        locations = locations,
        vehicles = vehicles,
        url = url,
    )
}