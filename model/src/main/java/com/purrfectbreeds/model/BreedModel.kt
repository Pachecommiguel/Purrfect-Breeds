package com.purrfectbreeds.model

data class BreedModel(
    val id: String,
    val url: String,
    val name: String,
    val isFavorite: Boolean = false
)
