package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.ImageModel
import com.purrfectbreeds.remote.dto.ImageDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageMapperImp @Inject constructor() : ImageMapper {

    override fun toModel(dto: List<ImageDto>) = dto
        .filterNot { it.breeds?.firstOrNull()?.name.isNullOrBlank() }
        .map {
            ImageModel(
                id = it.id ?: String(),
                url = it.url ?: String(),
                name = it.breeds!!.first().name!!
            )
        }
}