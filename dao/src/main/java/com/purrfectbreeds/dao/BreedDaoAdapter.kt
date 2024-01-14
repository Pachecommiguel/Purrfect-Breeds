package com.purrfectbreeds.dao

import com.purrfectbreeds.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedDaoAdapter {
    suspend fun addBreeds(breeds: List<BreedModel>)
    suspend fun getBreeds(page: Int): List<BreedModel>
    suspend fun getFavorites(page: Int): List<BreedModel>
    suspend fun changeFavorite(id: String)
    fun getFavorites(): Flow<List<BreedModel>>
}