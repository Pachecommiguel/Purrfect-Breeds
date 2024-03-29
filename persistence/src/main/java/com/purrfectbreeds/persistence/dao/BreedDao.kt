package com.purrfectbreeds.persistence.dao

import androidx.room.*
import com.purrfectbreeds.persistence.CustomRoomDatabase
import com.purrfectbreeds.persistence.entity.BreedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME} ORDER BY name LIMIT 10 OFFSET :offset")
    suspend fun getAll(offset: Int): List<BreedEntity>

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME}")
    fun getAll(): Flow<List<BreedEntity>>

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME} WHERE id=:id")
    fun get(id: String): Flow<BreedEntity>

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME} WHERE id=:id")
    suspend fun getById(id: String): BreedEntity?

    @Query("SELECT * FROM ${CustomRoomDatabase.BREED_TABLE_NAME} WHERE isFavorite=1")
    fun getFavorites(): Flow<List<BreedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breed: BreedEntity)

    @Update
    suspend fun update(breed: BreedEntity)
}