package com.purrfectbreeds.di

import com.purrfectbreeds.domain.*
import com.purrfectbreeds.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetBreedsUseCase(useCase: GetBreedsUseCaseImp): GetBreedsUseCase

    @Singleton
    @Binds
    abstract fun bindGetBreedUseCase(useCase: GetBreedUseCaseImp): GetBreedUseCase

    @Singleton
    @Binds
    abstract fun bindChangeFavoriteUseCase(useCase: ChangeFavoriteUseCaseImp): ChangeFavoriteUseCase

    @Singleton
    @Binds
    abstract fun bindGetOfflineBreedsUseCase(useCase: GetOfflineBreedsUseCaseImp): GetOfflineBreedsUseCase

    @Singleton
    @Binds
    abstract fun bindGetFavoritesUseCase(useCase: GetFavoritesUseCaseImp): GetFavoritesUseCase
}