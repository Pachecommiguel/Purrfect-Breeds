package com.pacheco.purrfectbreeds.ui.state

sealed class StateResult {
    object Loading : StateResult()
    object Error : StateResult()
    data class Success(val state: Any) : StateResult()
}