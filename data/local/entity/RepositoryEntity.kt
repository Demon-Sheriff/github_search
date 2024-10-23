package com.example.github_search.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.github_search.domain.model.Repository

@Entity(tableName = "repositories")
data class RepositoryEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val htmlUrl: String,
    val stars: Int,
    val forks: Int,
    val ownerAvatarUrl: String
) {
    fun toDomain() = Repository(
        id = id,
        name = name,
        fullName = fullName,
        description = description,
        htmlUrl = htmlUrl,
        stars = stars,
        forks = forks,
        ownerAvatarUrl = ownerAvatarUrl
    )

    companion object {
        fun fromDomain(repository: Repository) = RepositoryEntity(
            id = repository.id,
            name = repository.name,
            fullName = repository.fullName,
            description = repository.description,
            htmlUrl = repository.htmlUrl,
            stars = repository.stars,
            forks = repository.forks,
            ownerAvatarUrl = repository.ownerAvatarUrl
        )
    }
}