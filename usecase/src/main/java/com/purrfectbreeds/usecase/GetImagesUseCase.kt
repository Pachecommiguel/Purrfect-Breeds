package com.purrfectbreeds.usecase

import androidx.paging.PagingData
import com.purrfectbreeds.model.ImageModel
import kotlinx.coroutines.flow.Flow

interface GetImagesUseCase {
    suspend operator fun invoke(): Flow<PagingData<ImageModel>>
}