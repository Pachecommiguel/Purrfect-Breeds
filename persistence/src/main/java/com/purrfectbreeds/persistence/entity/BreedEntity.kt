package com.purrfectbreeds.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.purrfectbreeds.persistence.CustomRoomDatabase

@Entity(tableName = CustomRoomDatabase.BREED_TABLE_NAME)
data class BreedEntity(
    @PrimaryKey val id: String,
    val url: String,
    val name: String,
    var isFavorite: Boolean,
    val lifeSpan: String?,
    val origin: String?,
    val temperament: String?,
    val description: String?
)
