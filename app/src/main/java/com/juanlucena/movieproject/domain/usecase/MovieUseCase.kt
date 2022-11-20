package com.juanlucena.movieproject.domain.usecase

import com.juanlucena.movieproject.data.database.entity.toEntity
import com.juanlucena.movieproject.data.repository.MovieRepository
import com.juanlucena.movieproject.domain.model.Movie
import com.juanlucena.movieproject.domain.model.toDomain
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend fun getAllMovies() : List<Movie>{

        val movieListFromDb = repository.getAllMoviesFromDatabase()

        return if(movieListFromDb.isEmpty()){
            val movieList = repository.getAllMoviesFromApi().map { movieModel -> movieModel.toEntity() }
            repository.insertAllMovies(repository.getAllMoviesFromApi().map { movieModel -> movieModel.toEntity() })
            movieList.map { movieEntity -> movieEntity.toDomain() }
        }else{
            movieListFromDb.map { movieEntity -> movieEntity.toDomain() }
        }
    }

    suspend fun deleteMovieFromDatabase(movie: Movie){
        repository.deleteMovieFromDatabase(movie.toEntity())
    }

    suspend fun editMovieFromDatabase(movie: Movie, title: String, description: String){

        if(title.isNotEmpty() || description.isNotEmpty()){
            movie.description = description.ifEmpty { movie.description }
            movie.title = title.ifEmpty { movie.title }
            repository.editMovieFromDatabase(movie.toEntity())
        }
    }
}