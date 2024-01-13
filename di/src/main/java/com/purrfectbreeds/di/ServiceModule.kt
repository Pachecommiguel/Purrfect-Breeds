package com.purrfectbreeds.di

import com.purrfectbreeds.remote.RetrofitClient
import com.purrfectbreeds.remote.service.BreedService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideImageService(): BreedService = RetrofitClient.create(classType = BreedService::class.java)
}