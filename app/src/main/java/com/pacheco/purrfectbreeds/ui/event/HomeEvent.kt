package com.pacheco.purrfectbreeds.ui.event

sealed class HomeEvent {
    data class Search(val name: String): HomeEvent()
    data class ChangeFavorite(val id: String): HomeEvent()
}
