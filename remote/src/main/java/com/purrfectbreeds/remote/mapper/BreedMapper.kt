package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.dto.BreedDto

interface BreedMapper {
    fun toModel(dto: List<BreedDto>?): List<BreedModel>
}