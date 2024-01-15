package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pacheco.purrfectbreeds.R

@Composable
fun EmptyLayout(
    headline: String,
    body: String
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Headline(text = headline, modifier = Modifier.fillMaxHeight(0.33f))
        Image(
            painter = painterResource(id = R.drawable.no_cat),
            contentDescription = null
        )
        Title(text = body, modifier = Modifier.padding(top = 40.dp))
    }
}