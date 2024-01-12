package com.purrfectbreeds.remote.adapter

import com.purrfectbreeds.remote.mapper.ImageMapper
import com.purrfectbreeds.remote.service.ImageService
import com.purrfectbreeds.service.ImageServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageServiceAdapterImp @Inject constructor(
    private val imageMapper: ImageMapper,
    private val imageService: ImageService
) : ImageServiceAdapter {

    override suspend fun getAll() = imageMapper.toModel(dto = imageService.getImages())
}