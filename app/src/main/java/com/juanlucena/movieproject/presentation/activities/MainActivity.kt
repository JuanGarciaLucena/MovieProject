package com.juanlucena.movieproject.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanlucena.movieproject.databinding.ActivityMainBinding
import com.juanlucena.movieproject.domain.model.Movie
import com.juanlucena.movieproject.presentation.adapters.MovieAdapter
import com.juanlucena.movieproject.presentation.viewmodel.MovieViewModel
import com.juanlucena.movieproject.utils.Constants.Companion.MOVIE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val movieMutableList = mutableListOf<Movie>()

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData(){
        viewModel.getAllMovies()

        viewModel.movies.observe(this) { movies ->
            movieMutableList.clear()
            movieMutableList.addAll(movies)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter(){
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)
        binding.moviesRecyclerView.setHasFixedSize(false)
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.moviesRecyclerView.addItemDecoration(dividerItemDecoration)
        adapter = MovieAdapter(
            movieList = movieMutableList,
            onItemClick = {movie -> onItemClick(movie)},
            onItemDelete = {position -> onItemDelete(position)})
        binding.moviesRecyclerView.adapter = adapter
    }

    private fun onItemClick(movie: Movie){
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(MOVIE, movie)
        startActivity(intent)
    }

    private fun onItemDelete(position: Int){
        viewModel.deleteMovieFromDatabase(movieMutableList[position])
        movieMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}