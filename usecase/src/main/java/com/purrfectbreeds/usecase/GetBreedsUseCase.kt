package com.purrfectbreeds.usecase

import androidx.paging.PagingData
import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface GetBreedsUseCase {
    suspend operator fun invoke(): Flow<PagingData<BreedModel>>
}