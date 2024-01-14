package com.pacheco.purrfectbreeds.ui.state

import com.purrfectbreeds.model.BreedModel

data class FavoritesState(
    val favorites: List<BreedModel> = listOf()
)
