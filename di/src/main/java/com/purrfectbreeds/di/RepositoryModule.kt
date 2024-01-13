package com.purrfectbreeds.di

import com.purrfectbreeds.data.repository.BreedRepositoryImp
import com.purrfectbreeds.repository.BreedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindBreedRepository(repository: BreedRepositoryImp): BreedRepository
}