package com.purrfectbreeds.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.service.BreedServiceAdapter
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class BreedPagingSource(
    private val breedServiceAdapter: BreedServiceAdapter,
    private val breedDaoAdapter: BreedDaoAdapter
) : PagingSource<Int, BreedModel>() {

    override fun getRefreshKey(state: PagingState<Int, BreedModel>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>) = try {
        val currentPage = params.key ?: 0
        val breeds = breedServiceAdapter.getBreeds(page = currentPage)

        coroutineScope {
            launch {
                breedDaoAdapter.addBreeds(breeds = breeds)
            }
        }

        LoadResult.Page(
            data = breeds,
            prevKey = when(currentPage == 0) {
                true -> null
                false -> currentPage.dec()
            },
            nextKey = when(breeds.isEmpty()) {
                true -> null
                false -> currentPage.inc()
            }
        )
    } catch (exception: Exception) {
        LoadResult.Error(throwable = exception)
    }
}