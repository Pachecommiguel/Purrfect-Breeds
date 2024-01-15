package com.pacheco.purrfectbreeds.router

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
                setNavigationBar(navController = navController)
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
private fun setNavigationBar(navController: NavHostController) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.primary, tonalElevation = 0.dp) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        listOf(Screen.Breeds, Screen.Favorites).forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null,
                        modifier = Modifier.size(size = 40.dp)
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIndicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.background,
                    unselectedIconColor = MaterialTheme.colorScheme.surfaceBright,
                    selectedTextColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent
                ),
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
}