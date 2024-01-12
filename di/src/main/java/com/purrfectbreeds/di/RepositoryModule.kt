package com.purrfectbreeds.di

import com.purrfectbreeds.data.repository.ImageRepositoryImp
import com.purrfectbreeds.repository.ImageRepository
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
    abstract fun bindImageRepository(repository: ImageRepositoryImp): ImageRepository
}