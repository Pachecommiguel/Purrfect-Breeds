package com.purrfectbreeds.service

import com.purrfectbreeds.model.ImageModel

interface ImageServiceAdapter {
    suspend fun getAll(): List<ImageModel>
}