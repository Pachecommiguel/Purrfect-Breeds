package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.ImageModel
import com.purrfectbreeds.remote.dto.ImageDto

interface ImageMapper {
    fun toModel(dto: List<ImageDto>): List<ImageModel>
}