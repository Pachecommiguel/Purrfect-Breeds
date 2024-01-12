package com.purrfectbreeds.remote.mapper

import com.purrfectbreeds.model.ImageModel
import com.purrfectbreeds.remote.dto.ImageDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageMapperImp @Inject constructor() : ImageMapper {

    override fun toModel(dto: List<ImageDto>) = dto.filter { it.id != null }.map {
        ImageModel(id = it.id!!)
    }
}