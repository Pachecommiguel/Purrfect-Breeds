package com.pacheco.purrfectbreeds.router

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pacheco.purrfectbreeds.ui.component.Body
import com.pacheco.purrfectbreeds.ui.view.BreedsView
import com.pacheco.purrfectbreeds.ui.view.DetailsView
import com.pacheco.purrfectbreeds.ui.view.FavoritesView

@Composable
fun ApplicationNavHost(navController: NavHostController = rememberNavController()) {
    val isVisible = remember { mutableStateOf(value = true) }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        isVisible.value = destination.route != Destination.Details().getRouteWithId()
    }

    Scaffold(
        bottomBar = {
            if (isVisible.value) {
                getNavigationBar(navController = navController)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(paddingValues = it)
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            NavHost(navController = navController, startDestination = Destination.Breeds().route) {
                composable(route = Destination.Breeds().route) {
                    BreedsView { id ->
                        navController.navigate(route = Destination.Details(id = id).getRouteWithId())
                    }
                }

                composable(route = Destination.Favorites().route) {
                    FavoritesView { id ->
                        navController.navigate(route = Destination.Details(id = id).getRouteWithId())
                    }
                }

                composable(route = Destination.Details().getRouteWithId()) {
                    DetailsView()
                }
            }
        }
    }
}

@Composable
private fun getNavigationBar(navController: NavHostController) = NavigationBar {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    listOf(Screen.Breeds, Screen.Favorites).forEach { screen ->
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            label = {
                Body(text = screen.title)
            },
            selected = currentDestination?.hierarchy?.any { it.route == screen.destination.route } == true,
            onClick = {
                navController.navigate(route = screen.destination.route) {
                    popUpTo(id = navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}