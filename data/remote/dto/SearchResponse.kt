package com.example.github_search.data.remote.dto

data class SearchResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<RepositoryDto>
)