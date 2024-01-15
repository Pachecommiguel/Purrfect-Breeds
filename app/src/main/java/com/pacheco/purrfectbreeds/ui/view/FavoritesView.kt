package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pacheco.purrfectbreeds.ui.component.Body
import com.pacheco.purrfectbreeds.ui.component.BreedsGrid
import com.pacheco.purrfectbreeds.ui.component.EmptyLayout
import com.pacheco.purrfectbreeds.ui.component.Headline
import com.pacheco.purrfectbreeds.ui.res.FavoritesLabel
import com.pacheco.purrfectbreeds.ui.state.FavoritesState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.pacheco.purrfectbreeds.ui.viewmodel.FavoritesViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.StateProvider

@Composable
fun FavoritesView(
    viewModel: StateProvider<StateResult> = hiltViewModel<FavoritesViewModel>(),
    navigateToDetails: (String) -> Unit
) {
    val stateResult by viewModel.stateResult.collectAsState()

    when(stateResult) {
        StateResult.Loading -> {}
        StateResult.Error -> EmptyLayout(headline = FavoritesLabel.HEADLINE, body = FavoritesLabel.EMPTY_BODY)
        is StateResult.Success -> FavoritesLayout(
            state = (stateResult as StateResult.Success).state as FavoritesState,
            navigateToDetails = navigateToDetails
        )
    }
}

@Composable
private fun FavoritesLayout(
    state: FavoritesState,
    navigateToDetails: (String) -> Unit
) {
    Column {
        Headline(text = FavoritesLabel.HEADLINE)
        BreedsGrid(
            items = state.favorites,
            isFavoriteClickable = false,
            onClick = navigateToDetails
        ) {
            Body(text = String.format(format = FavoritesLabel.LIFE_SPAN, it.lifespan))
        }
    }
}