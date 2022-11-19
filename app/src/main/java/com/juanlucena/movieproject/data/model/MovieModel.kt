package com.juanlucena.movieproject.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel (

    @SerializedName("id") val id : String,
    @SerializedName("title") val title : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("original_title_romanised") val originalTitleRomanised : String,
    @SerializedName("image") val image : String,
    @SerializedName("movie_banner") val movieBanner : String,
    @SerializedName("description") val description : String,
    @SerializedName("director") val director : String,
    @SerializedName("producer") val producer : String,
    @SerializedName("release_date") val releaseDate : Int,
    @SerializedName("running_time") val runningTime : Int,
    @SerializedName("rt_score") val rtScore : Int,
    @SerializedName("people") val people : List<String>,
    @SerializedName("species") val species : List<String>,
    @SerializedName("locations") val locations : List<String>,
    @SerializedName("vehicles") val vehicles : List<String>,
    @SerializedName("url") val url : String
)