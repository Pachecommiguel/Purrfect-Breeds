package com.purrfectbreeds.persistence.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.entity.BreedEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedEntityMapperImp @Inject constructor() : BreedEntityMapper {

    override fun toEntity(model: List<BreedModel>) = model.map {
        BreedEntity(
            id = it.id,
            name = it.name,
            url = it.url,
            isFavorite = it.isFavorite,
            lifeSpan = it.lifespan,
            origin = it.origin,
            temperament = it.temperament,
            description = it.description
        )
    }

    override fun toModel(entity: List<BreedEntity>): List<BreedModel> = entity.map(::toModel)

    override fun toModel(entity: BreedEntity) = BreedModel(
        id = entity.id,
        name = entity.name,
        url = entity.url,
        isFavorite = entity.isFavorite,
        lifespan = entity.lifeSpan,
        origin = entity.origin,
        temperament = entity.temperament,
        description = entity.description
    )
}