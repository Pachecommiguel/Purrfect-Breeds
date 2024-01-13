package com.purrfectbreeds.persistence.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.entity.BreedEntity

interface BreedEntityMapper {
    fun toEntity(model: List<BreedModel>): List<BreedEntity>
}