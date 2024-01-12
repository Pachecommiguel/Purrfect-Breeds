package com.purrfectbreeds.remote.dto

import com.google.gson.annotations.SerializedName

data class BreedsDto(
    val id: String? = null,
    val name: String? = null,
    val temperament: String? = null,
    val origin: String? = null,
    val description: String? = null,
    @SerializedName("life_span") val lifeSpan: String? = null
)