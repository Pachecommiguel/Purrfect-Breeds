package com.purrfectbreeds.dao

import com.purrfectbreeds.model.BreedModel

interface BreedDaoAdapter {
    suspend fun addBreeds(breeds: List<BreedModel>)
    suspend fun getBreeds(page: Int): List<BreedModel>
}