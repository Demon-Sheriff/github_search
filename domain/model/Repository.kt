package com.example.github_search.domain.model

data class Repository(
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val htmlUrl: String,
    val stars: Int,
    val forks: Int,
    val ownerAvatarUrl: String
)