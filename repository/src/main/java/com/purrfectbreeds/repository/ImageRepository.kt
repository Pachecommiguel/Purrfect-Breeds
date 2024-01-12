package com.purrfectbreeds.repository

import com.purrfectbreeds.model.ImageModel

interface ImageRepository {
    suspend fun getAll(): List<ImageModel>
}