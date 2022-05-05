package com.example.recyclerview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.common.setMovieImage
import com.example.recyclerview.databinding.ActivityMovieItemBinding
import com.example.recyclerview.models.PopularModel
import com.example.recyclerview.ui.bottom_bar.BottomBarActivity

class MovieAdapter : ListAdapter<PopularModel, MovieAdapter.NotesViewHolder>(DiffUtil()) {

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<PopularModel>() {
        override fun areItemsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem == newItem
        }
    }

    class NotesViewHolder(private val binding: ActivityMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popular: PopularModel) {
            binding.movieImage.setMovieImage(popular.poster_path)
            binding.movieName.text = popular.original_title
            binding.movieOverview.text = popular.overview
            binding.itemView.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_navigation_home_to_navigation_detail,
                    bundleOf("popular" to popular)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = ActivityMovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NotesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}