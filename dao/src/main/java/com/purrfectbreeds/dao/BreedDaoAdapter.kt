package com.purrfectbreeds.dao

import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedDaoAdapter {
    suspend fun addBreeds(breeds: List<BreedModel>)
    suspend fun getBreeds(page: Int): List<BreedModel>
    suspend fun getAll(page: Int): List<BreedModel>
    suspend fun changeFavorite(id: String)
    fun getBreed(id: String): Flow<BreedModel>
    fun getAll(): Flow<List<BreedModel>>
    fun getFavorites(): Flow<List<BreedModel>>
}