package com.purrfectbreeds.repository

import androidx.paging.PagingData
import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedRepository {
    suspend fun getAllAsPaging(): Flow<PagingData<BreedModel>>
    suspend fun changeFavorite(id: String)
    fun getBreed(id: String): Flow<BreedModel>
    fun getAll(): Flow<List<BreedModel>>
    fun getFavorites(): Flow<List<BreedModel>>
}