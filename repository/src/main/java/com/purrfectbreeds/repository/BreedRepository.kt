package com.purrfectbreeds.repository

import androidx.paging.PagingData
import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedRepository {
    suspend fun getAll(): Flow<PagingData<BreedModel>>
    suspend fun changeFavorite(id: String)
    fun getFavorites(): Flow<List<BreedModel>>
}