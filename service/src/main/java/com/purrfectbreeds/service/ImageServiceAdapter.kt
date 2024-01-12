package com.purrfectbreeds.service

import androidx.paging.PagingData
import com.purrfectbreeds.model.ImageModel
import kotlinx.coroutines.flow.Flow

interface ImageServiceAdapter {
    suspend fun getAll(): Flow<PagingData<ImageModel>>
}