package com.example.github_search.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.github_search.data.local.dao.RepositoryDao
import com.example.github_search.data.local.entity.RepositoryEntity

@Database(entities = [RepositoryEntity::class], version = 1)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
}