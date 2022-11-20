package com.juanlucena.movieproject.domain.model

import com.juanlucena.movieproject.data.database.entity.MovieEntity
import com.juanlucena.movieproject.data.model.MovieModel

data class Movie(

    var id: String,
    var title: String,
    var originalTitle: String,
    var originalTitleRomanised: String,
    var image: String,
    var movieBanner: String,
    var description: String,
    var director: String,
    var producer: String,
    var releaseDate: Int,
    var runningTime: Int,
    var rtScore: Int,
    var people: List<String>,
    var species: List<String>,
    var locations: List<String>,
    var vehicles: List<String>,
    var url: String
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