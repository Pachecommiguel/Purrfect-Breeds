package com.purrfectbreeds.persistence.dao

import androidx.room.*
import com.purrfectbreeds.persistence.CustomRoomDatabase
import com.purrfectbreeds.persistence.entity.BreedEntity

@Dao
interface BreedDao {

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME} ORDER BY name LIMIT 10 OFFSET :offset")
    suspend fun getAll(offset: Int): List<BreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breed: BreedEntity)
}