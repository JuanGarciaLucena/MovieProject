package com.juanlucena.movieproject.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.juanlucena.movieproject.databinding.ActivityMovieDetailBinding
import com.juanlucena.movieproject.domain.model.Movie
import com.juanlucena.movieproject.presentation.fragments.EditMovieInfoFragment
import com.juanlucena.movieproject.presentation.viewmodel.MovieViewModel
import com.juanlucena.movieproject.utils.Constants.Companion.MOVIE
import com.juanlucena.movieproject.utils.Utils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var movie: Movie
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        initView()
        initListeners()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun initView(){
        movie = Utils.getSerializable(this, MOVIE, Movie::class.java)
        binding.movie = movie
    }

    private fun initListeners(){

        binding.editButton.setOnClickListener {
            val dialog =  EditMovieInfoFragment(onFinishEditing = {title, description -> onFinishEditing(title, description)})
            dialog.show(supportFragmentManager, "edit_fragment")
        }
    }

    private fun onFinishEditing(title: String, description: String){
        if(title.isNotEmpty()) binding.movieTitleTv.text = title
        if(description.isNotEmpty()) binding.movieDescriptionTv.text = description
        viewModel.editMovieFromDatabase(movie, title, description)
    }
}