package com.example.github_search.data.remote.dto

import com.example.github_search.domain.model.Repository

data class RepositoryDto(
    val id: Long,
    val name: String,
    val full_name: String,
    val description: String?,
    val html_url: String,
    val stargazers_count: Int,
    val forks_count: Int,
    val owner: OwnerDto
) {
    fun toDomain() = Repository(
        id = id,
        name = name,
        fullName = full_name,
        description = description ?: "",
        htmlUrl = html_url,
        stars = stargazers_count,
        forks = forks_count,
        ownerAvatarUrl = owner.avatar_url
    )
}

data class OwnerDto(
    val avatar_url: String
)