package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun FavoriteIcon(isFavorite: Boolean) {
    Icon(
        imageVector = Icons.Filled.Star,
        contentDescription = null,
        tint = when(isFavorite) {
            true -> MaterialTheme.colorScheme.primary
            false -> Color.Black
        }
    )
}