package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Info(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(text = text, style = MaterialTheme.typography.bodyMedium, modifier = modifier)
}