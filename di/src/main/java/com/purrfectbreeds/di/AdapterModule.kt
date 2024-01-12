package com.purrfectbreeds.di

import com.purrfectbreeds.remote.adapter.ImageServiceAdapterImp
import com.purrfectbreeds.remote.mapper.ImageMapper
import com.purrfectbreeds.remote.mapper.ImageMapperImp
import com.purrfectbreeds.service.ImageServiceAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdapterModule {

    @Singleton
    @Binds
    abstract fun bindImageServiceAdapter(adapter: ImageServiceAdapterImp): ImageServiceAdapter
}