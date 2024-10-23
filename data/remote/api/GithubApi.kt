package com.example.github_search.data.remote.api

import com.example.github_search.data.remote.dto.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): SearchResponse
}