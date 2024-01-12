package com.purrfectbreeds.di

import com.purrfectbreeds.remote.RetrofitClient
import com.purrfectbreeds.remote.service.ImageService
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
    fun provideImageService(): ImageService = RetrofitClient.create(classType = ImageService::class.java)
}