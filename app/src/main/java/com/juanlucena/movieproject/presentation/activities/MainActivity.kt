package com.juanlucena.movieproject.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanlucena.movieproject.databinding.ActivityMainBinding
import com.juanlucena.movieproject.presentation.adapters.MovieAdapter
import com.juanlucena.movieproject.presentation.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAllMovies()

        viewModel.movies.observe(this) { movies ->
            val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)
            binding.moviesRecyclerView.setHasFixedSize(false)
            binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.moviesRecyclerView.addItemDecoration(dividerItemDecoration)
            val adapter = MovieAdapter(
                movieList = movies)
            binding.moviesRecyclerView.adapter = adapter
        }
    }
}