package com.purrfectbreeds.usecase

import com.purrfectbreeds.model.ImageModel

interface GetImagesUseCase {
    suspend operator fun invoke(): List<ImageModel>
}