package com.purrfectbreeds.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.purrfectbreeds.persistence.dao.BreedDao
import com.purrfectbreeds.persistence.entity.BreedEntity

@Database(entities = [BreedEntity::class], version = 2, exportSchema = false)
abstract class CustomRoomDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "purrfect-db"
        const val BREED_TABLE_NAME = "breed"

        fun create(context: Context) = Room
            .databaseBuilder(context = context, klass = CustomRoomDatabase::class.java, name = DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
            .getBreedDao()
    }

    abstract fun getBreedDao(): BreedDao
}