package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.dto.BreedDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedMapperImp @Inject constructor() : BreedMapper {

    override fun toModel(dto: List<BreedDto>) = dto.map {
        BreedModel(
            id = it.id ?: String(),
            url = it.image?.url ?: String(),
            name = it.name ?: String()
        )
    }
}