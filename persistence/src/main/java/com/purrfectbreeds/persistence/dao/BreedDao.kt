package com.purrfectbreeds.persistence.dao

import androidx.room.*
import com.purrfectbreeds.persistence.CustomRoomDatabase
import com.purrfectbreeds.persistence.entity.BreedEntity

@Dao
interface BreedDao {

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME}")
    fun getAll(): List<BreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breed: BreedEntity)
}