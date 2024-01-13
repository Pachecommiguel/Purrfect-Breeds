package com.purrfectbreeds.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.purrfectbreeds.persistence.CustomRoomDatabase

@Entity(tableName = CustomRoomDatabase.BREED_TABLE_NAME)
data class BreedEntity(
    @PrimaryKey val id: String,
    val url: String,
    val name: String
)
