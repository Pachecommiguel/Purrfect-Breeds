package com.purrfectbreeds.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.purrfectbreeds.persistence.CustomRoomDatabase
import com.purrfectbreeds.persistence.entity.BreedEntity

@Dao
interface BreedDao {

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME}")
    fun getAll(): List<BreedEntity>

    @Insert
    fun insert(breed: BreedEntity)
}