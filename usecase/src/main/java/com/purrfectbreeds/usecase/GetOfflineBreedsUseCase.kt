package com.purrfectbreeds.usecase

import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface GetOfflineBreedsUseCase {
    operator fun invoke(): Flow<List<BreedModel>>
}