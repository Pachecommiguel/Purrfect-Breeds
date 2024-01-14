package com.purrfectbreeds.model

data class BreedModel(
    val id: String,
    val url: String,
    val name: String,
    var isFavorite: Boolean = false,
    val lifeSpan: String
)
