package com.pacheco.purrfectbreeds.ui.event

sealed class BreedsEvent {
    data class Search(val name: String): BreedsEvent()
    data class ChangeFavorite(val id: String): BreedsEvent()
    object Refresh: BreedsEvent()
}
