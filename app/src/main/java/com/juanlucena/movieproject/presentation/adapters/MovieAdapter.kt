package com.juanlucena.movieproject.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juanlucena.movieproject.databinding.AdapterMovieBinding
import com.juanlucena.movieproject.domain.model.Movie

class MovieAdapter(
    private val movieList: List<Movie>,
    private val onItemClick: (Movie) -> Unit,
    private val onItemDelete: (Int) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun getItemCount() = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class MovieViewHolder(private val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.movie = movie
            binding.movieItemContainer.setOnClickListener { onItemClick(movie) }
            binding.deleteMovieButton.setOnClickListener { onItemDelete(adapterPosition) }
        }
    }
}