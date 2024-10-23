package com.example.github_search.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.github_search.presentation.screens.details.DetailsScreen
import com.example.github_search.presentation.screens.home.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onRepositoryClick = { repository ->
                    navController.navigate("details/${repository.id}")
                }
            )
        }
        composable("details/{repositoryId}") {
            DetailsScreen(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}