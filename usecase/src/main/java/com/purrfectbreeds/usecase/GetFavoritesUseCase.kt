package com.purrfectbreeds.usecase

import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {
    operator fun invoke(): Flow<List<BreedModel>>
}