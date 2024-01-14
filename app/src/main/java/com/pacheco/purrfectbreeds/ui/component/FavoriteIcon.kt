package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun FavoriteIcon(tint: Color) {
    Icon(
        imageVector = Icons.Filled.Star,
        contentDescription = null,
        tint = tint
    )
}