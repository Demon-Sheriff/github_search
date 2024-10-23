package com.example.github_search.data.repository

import com.example.github_search.data.local.dao.RepositoryDao
import com.example.github_search.data.local.entity.RepositoryEntity
import com.example.github_search.data.remote.api.GithubApi
import com.example.github_search.domain.model.Repository
import com.example.github_search.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val api: GithubApi,
    private val dao: RepositoryDao
) : GithubRepository {

    override suspend fun searchRepositories(query: String, page: Int): List<Repository> {
        return api.searchRepositories(query, page).items.map { it.toDomain() }
    }

    override fun getSavedRepositories(): Flow<List<Repository>> {
        return dao.getAllRepositories().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun saveRepositories(repositories: List<Repository>) {
        dao.insertRepositories(repositories.map { RepositoryEntity.fromDomain(it) })
    }

    override suspend fun clearSavedRepositories() {
        dao.clearRepositories()
    }
}