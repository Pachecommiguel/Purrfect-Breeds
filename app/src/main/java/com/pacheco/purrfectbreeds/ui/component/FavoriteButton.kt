package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FavoriteButton(
    isFavorite: Boolean = true,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = when(isFavorite) {
                true -> MaterialTheme.colorScheme.primary
                false -> MaterialTheme.colorScheme.background
            }
        )
    }
}