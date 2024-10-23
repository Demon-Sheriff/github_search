package com.example.github_search.di

import android.content.Context
import androidx.room.Room
import com.example.github_search.data.local.GithubDatabase
import com.example.github_search.data.local.dao.RepositoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GithubDatabase {
        return Room.databaseBuilder(
            context,
            GithubDatabase::class.java,
            "github_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepositoryDao(database: GithubDatabase): RepositoryDao {
        return database.repositoryDao()
    }
}
