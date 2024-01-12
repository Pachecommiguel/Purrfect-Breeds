package com.pacheco.purrfectbreeds.ui.viewmodel

import com.pacheco.purrfectbreeds.ui.state.StateResult
import kotlinx.coroutines.flow.MutableStateFlow

interface StateProvider {
    val stateResult: MutableStateFlow<StateResult>
}