package com.purrfectbreeds.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.purrfectbreeds.model.ImageModel
import com.purrfectbreeds.remote.mapper.ImageMapper
import com.purrfectbreeds.remote.service.ImageService

class ImagePagingSource(
    private val imageService: ImageService,
    private val imageMapper: ImageMapper
) : PagingSource<Int, ImageModel>() {

    override fun getRefreshKey(state: PagingState<Int, ImageModel>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>) = try {
        val currentPage = params.key ?: 0
        val images = imageService.getImages(page = currentPage)

        LoadResult.Page(
            data = imageMapper.toModel(dto = images),
            prevKey = when(currentPage == 0) {
                true -> null
                false -> currentPage.dec()
            },
            nextKey = when(images.isEmpty()) {
                true -> null
                false -> currentPage.inc()
            }
        )
    } catch (exception: Exception) {
        LoadResult.Error(throwable = exception)
    }
}