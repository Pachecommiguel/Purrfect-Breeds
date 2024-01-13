package com.purrfectbreeds.service

import androidx.paging.PagingData
import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedServiceAdapter {
    suspend fun getAll(): Flow<PagingData<BreedModel>>
}