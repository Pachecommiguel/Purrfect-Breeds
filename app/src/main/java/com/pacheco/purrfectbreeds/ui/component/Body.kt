package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Body(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(text = text, style = MaterialTheme.typography.bodyLarge, modifier = modifier)
}