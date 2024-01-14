package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pacheco.purrfectbreeds.ui.component.*
import com.pacheco.purrfectbreeds.ui.event.DetailsEvent
import com.pacheco.purrfectbreeds.ui.res.DetailsLabel
import com.pacheco.purrfectbreeds.ui.state.DetailsState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.DetailsViewModel

@Composable
fun DetailsView(
    viewModel: BaseViewModel<DetailsEvent, StateResult> = hiltViewModel<DetailsViewModel>()
) {
    val stateResult by viewModel.stateResult.collectAsState()

    when(stateResult) {
        StateResult.Loading -> {}
        is StateResult.Success -> DetailsLayout(
            onEvent = viewModel::onEvent,
            state = (stateResult as StateResult.Success).state as DetailsState
        )
    }
}

@Composable
private fun DetailsLayout(
    onEvent: (DetailsEvent) -> Unit,
    state: DetailsState
) {
    Column {
        Headline(text = state.breed.name)
        Surface(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
            CatImage(url = state.breed.url)
            Box(contentAlignment = Alignment.TopEnd) {
                FavoriteButton(isFavorite = state.breed.isFavorite) {
                    onEvent(DetailsEvent.ChangeFavorite(id = state.breed.id))
                }
            }
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp),
        ) {
            Title(text = DetailsLabel.ORIGIN)
            Body(text = state.breed.origin)
            Title(text = DetailsLabel.TEMPERAMENT, modifier = Modifier.padding(top = 10.dp))
            Body(text = state.breed.temperament)
            Title(text = DetailsLabel.DESCRIPTION, modifier = Modifier.padding(top = 10.dp))
            Body(text = state.breed.description)
        }
    }
}