package com.pacheco.purrfectbreeds.ui.state

sealed class StateResult {
    object Loading: StateResult()
    data class Success(val state: Any): StateResult()
}
