package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.dto.BreedDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedMapperImp @Inject constructor() : BreedMapper {

    override fun toModel(dto: List<BreedDto>) = dto.map {
        val lifespan = it.lifespan?.filter(Char::isDigit)
        BreedModel(
            id = it.id ?: String(),
            url = it.image?.url ?: String(),
            name = it.name ?: String(),
            lifespan = lifespan?.take(lifespan.length / 2) ?: "-",
            temperament = it.temperament ?: "-",
            origin = it.origin ?: "-",
            description = it.description ?: "-"
        )
    }
}