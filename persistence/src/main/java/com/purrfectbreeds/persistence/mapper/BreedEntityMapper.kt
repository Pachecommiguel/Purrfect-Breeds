package com.purrfectbreeds.persistence.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.entity.BreedEntity

interface BreedEntityMapper {
    fun toEntity(model: List<BreedModel>): List<BreedEntity>
    fun toModel(entity: List<BreedEntity>): List<BreedModel>
    fun toModel(entity: BreedEntity): BreedModel
}