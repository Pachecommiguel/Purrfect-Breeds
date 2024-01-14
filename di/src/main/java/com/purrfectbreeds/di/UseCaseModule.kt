package com.purrfectbreeds.di

import com.purrfectbreeds.domain.GetBreedsUseCaseImp
import com.purrfectbreeds.domain.MarkAsFavoriteUseCaseImp
import com.purrfectbreeds.usecase.GetBreedsUseCase
import com.purrfectbreeds.usecase.MarkAsFavoriteUseCase
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
    abstract fun bindMarkAsFavoriteUseCase(useCase: MarkAsFavoriteUseCaseImp): MarkAsFavoriteUseCase
}