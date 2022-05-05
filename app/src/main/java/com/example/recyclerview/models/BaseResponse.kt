package com.example.recyclerview.models

data class BaseResponse<T>(
    val id: Int,
    val page: Int,
    val results: T,
    val total_pages: Int,
    val total_results: Int,
)
