package com.purrfectbreeds.remote.adapter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.purrfectbreeds.remote.ImagePagingSource
import com.purrfectbreeds.remote.mapper.ImageMapper
import com.purrfectbreeds.remote.service.ImageService
import com.purrfectbreeds.service.ImageServiceAdapter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageServiceAdapterImp @Inject constructor(
    private val imageService: ImageService,
    private val imageMapper: ImageMapper
) : ImageServiceAdapter {

    override suspend fun getAll() = Pager(
        config = PagingConfig(pageSize = 30, prefetchDistance = 30),
        pagingSourceFactory = {
            ImagePagingSource(imageService = imageService, imageMapper = imageMapper)
        }
    ).flow
}