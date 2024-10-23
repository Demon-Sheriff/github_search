package com.example.github_search.domain.repository

import com.example.github_search.domain.model.Repository
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun searchRepositories(query: String, page: Int): List<Repository>
    fun getSavedRepositories(): Flow<List<Repository>>
    suspend fun saveRepositories(repositories: List<Repository>)
    suspend fun clearSavedRepositories()
}