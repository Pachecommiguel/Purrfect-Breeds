package com.purrfectbreeds.usecase

import com.purrfectbreeds.model.BreedModel

interface GetBreedUseCase {
    suspend operator fun invoke(id: String): BreedModel
}