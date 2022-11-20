package com.juanlucena.movieproject.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juanlucena.movieproject.databinding.ActivityMovieDetailBinding
import com.juanlucena.movieproject.domain.model.Movie
import com.juanlucena.movieproject.utils.Constants.Companion.MOVIE
import com.juanlucena.movieproject.utils.Utils

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        movie = Utils.getSerializable(this, MOVIE, Movie::class.java)
        binding.movie = movie
    }


}