package com.purrfectbreeds.test.persistence

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.adapter.BreedDaoAdapterImp
import com.purrfectbreeds.persistence.dao.BreedDao
import com.purrfectbreeds.persistence.mapper.BreedEntityMapper
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BreedDaoAdapterImpTest {

    private val breedDao = mock<BreedDao>()
    private val breedMapper = mock<BreedEntityMapper>()
    private val breedDaoAdapter = BreedDaoAdapterImp(breedDao = breedDao, breedMapper = breedMapper)

    @Test
    fun shouldReturnOnlyFavorites() {
        val model = listOf(
            BreedModel(isFavorite = true),
            BreedModel(isFavorite = false)
        )

        runBlocking {
            `when`(breedDao.getAll(offset = anyInt())).thenReturn(listOf())
            `when`(breedMapper.toModel(entity = anyList())).thenReturn(model)

            val result = breedDaoAdapter.getAll(page = anyInt())
            assertEquals(1, result.size)
            assert(result.first().isFavorite)
        }
    }
}