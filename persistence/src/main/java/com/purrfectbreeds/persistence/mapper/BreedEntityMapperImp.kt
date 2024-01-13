package com.purrfectbreeds.persistence.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.entity.BreedEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedEntityMapperImp @Inject constructor() : BreedEntityMapper {

    override fun toEntity(model: List<BreedModel>) = model.map {
        BreedEntity(id = it.id, name = it.name, url = it.url)
    }

    override fun toModel(entity: List<BreedEntity>) = entity.map {
        BreedModel(id = it.id, name = it.name, url = it.url)
    }.sortedBy(BreedModel::name)
}