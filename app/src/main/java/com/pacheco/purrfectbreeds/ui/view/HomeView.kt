package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.HomeViewModel

@Composable
fun HomeView(
    viewModel: BaseViewModel<HomeEvent> = hiltViewModel<HomeViewModel>(),
) {
    val stateResult by viewModel.stateResult.collectAsState()

    when(stateResult) {
        StateResult.Error -> TODO()
        StateResult.Loading -> TODO()
        StateResult.Success -> TODO()
    }
}