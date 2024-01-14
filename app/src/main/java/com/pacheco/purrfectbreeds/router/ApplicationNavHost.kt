package com.pacheco.purrfectbreeds.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pacheco.purrfectbreeds.ui.view.DetailsView
import com.pacheco.purrfectbreeds.ui.view.FavoritesView
import com.pacheco.purrfectbreeds.ui.view.HomeView

@Composable
fun ApplicationNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Destination.HOME.name) {
        composable(route = Destination.HOME.name) {
            HomeView(navigateToFavorites = {
                navController.navigate(route = Destination.FAVORITES.name)
            }) {
                navController.navigate(route = Destination.DETAILS.name + "/" + it)
            }
        }

        composable(route = Destination.FAVORITES.name) {
            FavoritesView {
                navController.navigate(route = Destination.DETAILS.name + "/" + it)
            }
        }

        composable(route = Destination.DETAILS.name + "/{id}") {
            DetailsView()
        }
    }
}