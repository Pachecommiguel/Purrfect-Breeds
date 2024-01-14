package com.purrfectbreeds.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.service.BreedServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedRepositoryImp @Inject constructor(
    private val breedServiceAdapter: BreedServiceAdapter,
    private val breedDaoAdapter: BreedDaoAdapter
) : BreedRepository {

    override suspend fun getAll() = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 20),
        pagingSourceFactory = {
            BreedPagingSource(
                breedServiceAdapter = breedServiceAdapter,
                breedDaoAdapter = breedDaoAdapter
            )
        }
    ).flow

    override suspend fun changeFavorite(id: String) {
        breedDaoAdapter.changeFavorite(id = id)
    }

    override suspend fun getBreed(id: String) = breedDaoAdapter.getBreed(id = id)

    override fun getFavorites() = breedDaoAdapter.getFavorites()
}