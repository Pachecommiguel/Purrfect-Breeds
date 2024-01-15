package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteSingleClickButton(onClick: () -> Unit) {
    val isClicked = remember {
        mutableStateOf(value = false)
    }

    IconButton(onClick = {
        if (isClicked.value.not()) {
            isClicked.value = true
            onClick()
        }
    }) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(size = 40.dp)
        )
    }
}