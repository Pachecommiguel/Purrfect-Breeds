package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.pacheco.purrfectbreeds.R

@Composable
fun CatImage(
    url: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = url,
        contentDescription = null,
        error = painterResource(id = R.drawable.ic_downloading),
        placeholder = painterResource(id = R.drawable.ic_downloading),
        modifier = modifier
    )
}