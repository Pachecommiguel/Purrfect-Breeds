package com.purrfectbreeds.data.repository

import com.purrfectbreeds.repository.ImageRepository
import com.purrfectbreeds.service.ImageServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImp @Inject constructor(
    private val imageServiceAdapter: ImageServiceAdapter
) : ImageRepository {

    override suspend fun getAll() = imageServiceAdapter.getAll()
}