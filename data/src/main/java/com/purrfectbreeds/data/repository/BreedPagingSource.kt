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

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BreedModel> {
        val currentPage = params.key ?: 0
        return try {
            val breeds = breedServiceAdapter.getBreeds(page = currentPage)
            saveBreeds(breeds = breeds)
            getPageLoadResult(
                breeds = mergeBreeds(breeds = breeds, favorites = breedDaoAdapter.getAll(page = currentPage)),
                currentPage = currentPage
            )
        } catch (exception: Exception) {
            val breeds = breedDaoAdapter.getBreeds(page = currentPage)
            when(breeds.isEmpty() && currentPage == 0) {
                true -> LoadResult.Error(throwable = exception)
                false -> getPageLoadResult(breeds = breeds, currentPage = currentPage)
            }
        }
    }

    private fun mergeBreeds(
        breeds: List<BreedModel>,
        favorites: List<BreedModel>
    ) = (favorites + breeds).distinctBy(BreedModel::id).sortedBy(BreedModel::name)

    private suspend fun saveBreeds(breeds: List<BreedModel>) {
        coroutineScope {
            launch {
                breedDaoAdapter.addBreeds(breeds = breeds)
            }
        }
    }

    private fun getPageLoadResult(
        breeds: List<BreedModel>,
        currentPage: Int
    ) = LoadResult.Page(
        data = breeds,
        prevKey = if (currentPage == 0) null else currentPage.dec(),
        nextKey = if (breeds.isEmpty()) null else currentPage.inc()
    )
}