package com.purrfectbreeds.repository

import androidx.paging.PagingData
import com.purrfectbreeds.model.ImageModel
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getAll(): Flow<PagingData<ImageModel>>
}