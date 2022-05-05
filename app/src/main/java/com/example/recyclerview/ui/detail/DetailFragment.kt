package com.example.recyclerview.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.recyclerview.common.setMovieImage
import com.example.recyclerview.databinding.FragmentDetailBinding
import com.example.recyclerview.models.PopularModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.findNavController
import com.example.recyclerview.R

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var movieID: Int
        arguments?.getParcelable<PopularModel>("popular").let {
            movieID = it!!.id
        }
        detailViewModel.getMovieDetail(movieID = movieID)

        detailViewModel.movieDetail.observe(this, {
            binding.apply {
                movieImage.setMovieImage(it.poster_path)
                movieName.text = it.original_title
                movieOverview.text = it.overview
            }
        })

        binding.btnBack.setOnClickListener {
            it.findNavController().popBackStack()
        }

        binding.apply {
            var isFavorite = true
            btnFavorite.setOnClickListener {
                if (isFavorite) {
                    btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_true)
                    Toast.makeText(activity, "Added to favorite list", Toast.LENGTH_SHORT).show()
                } else {
                    btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24_false)
                    Toast.makeText(activity, "Removed from favorite list", Toast.LENGTH_SHORT).show()
                }
                isFavorite = !isFavorite
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}