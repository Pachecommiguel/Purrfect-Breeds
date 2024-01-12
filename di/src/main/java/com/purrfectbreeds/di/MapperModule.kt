package com.purrfectbreeds.di

import com.purrfectbreeds.remote.mapper.ImageMapper
import com.purrfectbreeds.remote.mapper.ImageMapperImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Singleton
    @Binds
    abstract fun bindImageMapper(mapper: ImageMapperImp): ImageMapper
}