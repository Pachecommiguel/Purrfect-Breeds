package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

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
        FavoriteIcon(tint = MaterialTheme.colorScheme.primary)
    }
}