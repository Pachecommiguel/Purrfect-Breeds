package com.purrfectbreeds.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.mapper.BreedMapper
import com.purrfectbreeds.remote.service.BreedService

class BreedPagingSource(
    private val breedService: BreedService,
    private val breedMapper: BreedMapper
) : PagingSource<Int, BreedModel>() {

    override fun getRefreshKey(state: PagingState<Int, BreedModel>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>) = try {
        val currentPage = params.key ?: 0
        val breeds = breedService.getBreeds(page = currentPage)

        LoadResult.Page(
            data = breedMapper.toModel(dto = breeds),
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