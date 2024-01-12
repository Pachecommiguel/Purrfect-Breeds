package com.purrfectbreeds.di

import com.purrfectbreeds.domain.GetImagesUseCaseImp
import com.purrfectbreeds.usecase.GetImagesUseCase
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
    abstract fun bindGetImagesUseCase(useCase: GetImagesUseCaseImp): GetImagesUseCase
}