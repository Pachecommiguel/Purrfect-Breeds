package com.purrfectbreeds.usecase

import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface GetBreedUseCase {
    operator fun invoke(id: String): Flow<BreedModel>
}