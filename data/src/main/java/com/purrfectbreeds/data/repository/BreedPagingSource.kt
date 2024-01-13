package com.purrfectbreeds.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.service.BreedServiceAdapter
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BreedPagingSource(
    private val breedServiceAdapter: BreedServiceAdapter,
    private val breedDaoAdapter: BreedDaoAdapter
) : PagingSource<Int, BreedModel>() {

    override fun getRefreshKey(state: PagingState<Int, BreedModel>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BreedModel> {
        val currentPage = params.key ?: 0

        return try {
            val breeds = breedServiceAdapter.getBreeds(page = currentPage)
            coroutineScope {
                launch {
                    breedDaoAdapter.addBreeds(breeds = breeds)
                }
            }
            getPageLoadResult(breeds = breeds, currentPage = currentPage)
        } catch (exception: Exception) {
            val breeds: List<BreedModel>
            runBlocking {
                breeds = breedDaoAdapter.getBreeds(page = currentPage)
            }
            when (breeds.isEmpty()) {
                true -> LoadResult.Error(throwable = exception)
                false -> getPageLoadResult(breeds = breeds, currentPage = currentPage)
            }
        }
    }

    private fun getPageLoadResult(breeds: List<BreedModel>, currentPage: Int) = LoadResult.Page(
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
}