package com.juanlucena.movieproject.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanlucena.movieproject.domain.model.Movie
import com.juanlucena.movieproject.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val useCase: MovieUseCase): ViewModel(){

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getAllMovies(){
        viewModelScope.launch {
            _movies.postValue(useCase.getAllMovies())
        }
    }

    fun deleteMovieFromDatabase(movie: Movie){
        viewModelScope.launch {
            useCase.deleteMovieFromDatabase(movie)
        }
    }
}