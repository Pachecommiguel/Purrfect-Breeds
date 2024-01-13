package com.purrfectbreeds.remote.adapter

import com.purrfectbreeds.remote.mapper.BreedMapper
import com.purrfectbreeds.remote.service.BreedService
import com.purrfectbreeds.service.BreedServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedServiceAdapterImp @Inject constructor(
    private val breedService: BreedService,
    private val breedMapper: BreedMapper
) : BreedServiceAdapter {

    override suspend fun getBreeds(page: Int) = breedMapper.toModel(
        dto = breedService.getBreeds(page = page)
    )
}