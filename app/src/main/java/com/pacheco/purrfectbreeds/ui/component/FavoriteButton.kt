package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.pacheco.purrfectbreeds.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    isClickable: Boolean = true,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick, enabled = isClickable) {
        Icon(
            imageVector = when (isFavorite) {
                true -> Icons.Filled.Star
                false -> ImageVector.vectorResource(id = R.drawable.ic_star_outline)
            },
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null,
            modifier = Modifier.size(size = 40.dp)
        )
    }
}