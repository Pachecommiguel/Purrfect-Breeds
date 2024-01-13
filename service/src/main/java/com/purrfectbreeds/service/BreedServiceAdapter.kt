package com.purrfectbreeds.service

import com.purrfectbreeds.model.BreedModel

interface BreedServiceAdapter {
    suspend fun getBreeds(page: Int): List<BreedModel>
}