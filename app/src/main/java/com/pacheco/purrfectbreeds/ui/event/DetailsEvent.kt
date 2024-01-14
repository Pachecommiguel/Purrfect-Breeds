package com.pacheco.purrfectbreeds.ui.event

sealed class DetailsEvent {
    data class ChangeFavorite(val id: String): DetailsEvent()
}
