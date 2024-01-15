package com.pacheco.purrfectbreeds.router

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val destination: Destination,
    val icon: ImageVector,
    var title: String
) {
    object Breeds : Screen(
        destination = Destination.Breeds(),
        icon = Icons.Filled.Home,
        title = ScreenLabel.BREEDS
    )

    object Favorites : Screen(
        destination = Destination.Favorites(),
        icon = Icons.Filled.Star,
        title = ScreenLabel.FAVORITES
    )
}