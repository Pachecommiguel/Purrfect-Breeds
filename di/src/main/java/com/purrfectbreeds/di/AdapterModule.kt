package com.purrfectbreeds.di

import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.persistence.adapter.BreedDaoAdapterImp
import com.purrfectbreeds.remote.adapter.BreedServiceAdapterImp
import com.purrfectbreeds.service.BreedServiceAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdapterModule {

    @Singleton
    @Binds
    abstract fun bindBreedServiceAdapter(adapter: BreedServiceAdapterImp): BreedServiceAdapter

    @Singleton
    @Binds
    abstract fun bindBreedDaoAdapter(adapter: BreedDaoAdapterImp): BreedDaoAdapter
}