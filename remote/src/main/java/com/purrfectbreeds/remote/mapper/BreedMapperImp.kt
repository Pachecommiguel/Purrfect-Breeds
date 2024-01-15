package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.dto.BreedDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedMapperImp @Inject constructor() : BreedMapper {

    override fun toModel(dto: List<BreedDto>) = dto
        .filter { it.id.isNullOrBlank().not() && it.name.isNullOrBlank().not() }
        .map {
            val lifespan = it.lifespan?.filter(Char::isDigit)
            BreedModel(
                id = it.id!!,
                url = it.image?.url ?: String(),
                name = it.name!!,
                lifespan = lifespan?.take(lifespan.length / 2),
                temperament = it.temperament,
                origin = it.origin,
                description = it.description
            )
        }
}