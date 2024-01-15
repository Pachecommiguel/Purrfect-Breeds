package com.purrfectbreeds.model

data class BreedModel(
    val id: String = String(),
    val url: String = String(),
    val name: String = String(),
    var isFavorite: Boolean = false,
    val lifespan: String? = null,
    val origin: String? = null,
    val temperament: String? = null,
    val description: String? = null
)
