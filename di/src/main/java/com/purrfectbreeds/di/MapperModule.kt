package com.purrfectbreeds.di

import com.purrfectbreeds.remote.mapper.BreedMapper
import com.purrfectbreeds.remote.mapper.BreedMapperImp
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
    abstract fun bindBreedMapper(mapper: BreedMapperImp): BreedMapper
}