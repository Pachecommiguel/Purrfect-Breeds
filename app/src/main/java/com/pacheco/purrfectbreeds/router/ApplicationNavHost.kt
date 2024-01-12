package com.pacheco.purrfectbreeds.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pacheco.purrfectbreeds.ui.view.HomeView

@Composable
fun ApplicationNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Destination.HOME.name) {
        composable(route = Destination.HOME.name) {
            HomeView()
        }
    }
}