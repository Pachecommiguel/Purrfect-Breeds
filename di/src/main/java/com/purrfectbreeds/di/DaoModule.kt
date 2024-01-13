package com.purrfectbreeds.di

import android.content.Context
import com.purrfectbreeds.persistence.CustomRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideBreeDao(@ApplicationContext context: Context) = CustomRoomDatabase.create(context = context)
}