package com.purrfectbreeds.di

import com.purrfectbreeds.domain.GetBreedsUseCaseImp
import com.purrfectbreeds.usecase.GetBreedsUseCase
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
}