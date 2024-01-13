package com.purrfectbreeds.data.repository

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.service.BreedServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedRepositoryImp @Inject constructor(
    private val breedServiceAdapter: BreedServiceAdapter
) : BreedRepository {

    override suspend fun getAll() = breedServiceAdapter.getAll()
}