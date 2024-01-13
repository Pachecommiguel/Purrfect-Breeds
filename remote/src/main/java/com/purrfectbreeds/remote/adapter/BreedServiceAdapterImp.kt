package com.purrfectbreeds.remote.adapter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.purrfectbreeds.remote.BreedPagingSource
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

    override suspend fun getAll() = Pager(
        config = PagingConfig(pageSize = 100, prefetchDistance = 50),
        pagingSourceFactory = {
            BreedPagingSource(breedService = breedService, breedMapper = breedMapper)
        }
    ).flow
}