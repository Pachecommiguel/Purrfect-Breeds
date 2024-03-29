package com.pacheco.purrfectbreeds.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow

interface StateProvider<TState> {
    val stateResult: MutableStateFlow<TState>
}