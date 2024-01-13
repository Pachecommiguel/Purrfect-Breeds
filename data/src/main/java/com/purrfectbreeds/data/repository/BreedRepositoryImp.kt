package com.purrfectbreeds.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.service.BreedServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedRepositoryImp @Inject constructor(
    private val breedServiceAdapter: BreedServiceAdapter
) : BreedRepository {

    override suspend fun getAll() = Pager(
        config = PagingConfig(pageSize = 100, prefetchDistance = 50),
        pagingSourceFactory = {
            BreedPagingSource(breedServiceAdapter = breedServiceAdapter)
        }
    ).flow
}