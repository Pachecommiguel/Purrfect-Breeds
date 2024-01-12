package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Headline(text: String) {
    Text(text = text, style = MaterialTheme.typography.headlineLarge)
}