package com.purrfectbreeds.remote.dto

data class ImageDto(
    val breeds: List<BreedsDto>? = null,
    val id: String? = null,
    val url: String? = null
)
