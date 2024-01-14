package com.purrfectbreeds.di

import com.purrfectbreeds.domain.GetBreedsUseCaseImp
import com.purrfectbreeds.domain.GetFavoritesUseCaseImp
import com.purrfectbreeds.domain.ChangeFavoriteUseCaseImp
import com.purrfectbreeds.usecase.GetBreedsUseCase
import com.purrfectbreeds.usecase.GetFavoritesUseCase
import com.purrfectbreeds.usecase.ChangeFavoriteUseCase
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
    abstract fun bindChangeFavoriteUseCase(useCase: ChangeFavoriteUseCaseImp): ChangeFavoriteUseCase

    @Singleton
    @Binds
    abstract fun bindGetFavoritesUseCase(useCase: GetFavoritesUseCaseImp): GetFavoritesUseCase
}