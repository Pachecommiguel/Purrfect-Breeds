package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pacheco.purrfectbreeds.ui.component.Body
import com.pacheco.purrfectbreeds.ui.component.BreedsGrid
import com.pacheco.purrfectbreeds.ui.component.Headline
import com.pacheco.purrfectbreeds.ui.event.FavoritesEvent
import com.pacheco.purrfectbreeds.ui.res.FavoritesLabel
import com.pacheco.purrfectbreeds.ui.state.FavoritesState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.FavoritesViewModel

@Composable
fun FavoritesView(
    viewModel: BaseViewModel<FavoritesEvent, StateResult> = hiltViewModel<FavoritesViewModel>()
) {
    val stateResult by viewModel.stateResult.collectAsState()

    when(stateResult) {
        StateResult.Loading -> {}
        is StateResult.Success -> FavoritesLayout(
            onEvent = viewModel::onEvent,
            state = (stateResult as StateResult.Success).state as FavoritesState
        )
    }
}

@Composable
private fun FavoritesLayout(
    onEvent: (FavoritesEvent) -> Unit,
    state: FavoritesState
) {
    Column {
        Headline(text = FavoritesLabel.HEADLINE)
        BreedsGrid(items = state.favorites, isFavoriteClickable = false) {
            Body(text = String.format(format = FavoritesLabel.LIFE_SPAN, it.lifeSpan))
        }
    }
}