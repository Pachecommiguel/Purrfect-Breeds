package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FavoriteButton(
    isFavorite: Boolean = true,
    isClickable: Boolean = true,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick, enabled = isClickable) {
        FavoriteIcon(tint = when(isFavorite) {
            true -> MaterialTheme.colorScheme.primary
            false -> MaterialTheme.colorScheme.background
        })
    }
}