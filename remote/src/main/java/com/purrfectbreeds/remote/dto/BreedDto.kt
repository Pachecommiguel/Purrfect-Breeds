package com.purrfectbreeds.remote.dto

import com.google.gson.annotations.SerializedName

data class BreedDto(
    val id: String? = null,
    val name: String? = null,
    val temperament: String? = null,
    val origin: String? = null,
    val description: String? = null,
    val image: ImageDto? = null,
    @SerializedName("life_span") val lifespan: String? = null
)