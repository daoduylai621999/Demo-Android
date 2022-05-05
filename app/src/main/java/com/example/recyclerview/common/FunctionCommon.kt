package com.example.recyclerview.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.recyclerview.R

fun ImageView.setMovieImage(posterPath: String?) {
    Glide.with(this)
        .load(StringConstant.BASE_URL_IMAGE + posterPath)
        .placeholder(R.drawable.ic_baseline_image_24)
        .into(this)
}