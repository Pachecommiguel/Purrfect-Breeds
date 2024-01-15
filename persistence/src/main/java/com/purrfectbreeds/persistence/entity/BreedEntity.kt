package com.purrfectbreeds.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.purrfectbreeds.persistence.CustomRoomDatabase

@Entity(tableName = CustomRoomDatabase.BREED_TABLE_NAME)
data class BreedEntity(
    @PrimaryKey val id: String = String(),
    val url: String = String(),
    val name: String = String(),
    var isFavorite: Boolean = false,
    val lifeSpan: String? = null,
    val origin: String? = null,
    val temperament: String? = null,
    val description: String? = null
)
