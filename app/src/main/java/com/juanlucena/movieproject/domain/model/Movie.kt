package com.juanlucena.movieproject.domain.model

import com.juanlucena.movieproject.data.database.entity.MovieEntity
import com.juanlucena.movieproject.data.model.MovieModel

data class Movie(

    val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanised: String,
    val image: String,
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    val releaseDate: Int,
    val runningTime: Int,
    val rtScore: Int,
    val people: List<String>,
    val species: List<String>,
    val locations: List<String>,
    val vehicles: List<String>,
    val url: String
) : java.io.Serializable

fun MovieEntity.toDomain(): Movie {
    return Movie(
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

fun MovieModel.toDomain(): Movie {
    return Movie(
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