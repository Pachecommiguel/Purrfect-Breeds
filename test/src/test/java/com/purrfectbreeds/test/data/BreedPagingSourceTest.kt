package com.purrfectbreeds.test.data

import androidx.paging.PagingSource
import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.data.repository.BreedPagingSource
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.service.BreedServiceAdapter
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BreedPagingSourceTest {

    private val service = mock<BreedServiceAdapter>()
    private val dao = mock<BreedDaoAdapter>()
    private val breedPagingSource = BreedPagingSource(breedDaoAdapter = dao, breedServiceAdapter = service)

    @Test
    fun shouldReturnErrorWhenApiIsUnavailableAndDatabaseIsEmptyAndItsTheFirstPage() {
        runBlocking {
            `when`(service.getBreeds(page = anyInt())).thenThrow(RuntimeException())
            `when`(dao.getBreeds(page = anyInt())).thenReturn(listOf())

            val result = breedPagingSource.load(params = PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 1,
                placeholdersEnabled = false
            ))

            assert(result is PagingSource.LoadResult.Error)
        }
    }

    @Test
    fun shouldReturnLoadWithBreedsFromApiAndDatabaseEmpty() {
        val list = listOf(
            BreedModel(id = "1"),
            BreedModel(id = "2")
        )

        runBlocking {
            `when`(service.getBreeds(page = anyInt())).thenReturn(list)
            `when`(dao.addBreeds(breeds = anyList())).thenReturn(Unit)
            `when`(dao.getAll(page = anyInt())).thenReturn(listOf())

            val result = breedPagingSource.load(params = PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 1,
                placeholdersEnabled = false
            ))

            assert(result is PagingSource.LoadResult.Page)
            assertEquals(list, (result as PagingSource.LoadResult.Page).data)
        }
    }

    @Test
    fun shouldReturnLoadWithBreedsFromApiAndDatabaseIsFavorite() {
        val model = BreedModel(id = "3", isFavorite = true)
        val list = listOf(
            BreedModel(id = "1", isFavorite = false),
            BreedModel(id = "2", isFavorite = false),
            model
        )

        val database = listOf(
            BreedModel(id = "1", isFavorite = true),
            BreedModel(id = "2", isFavorite = false)
        )

        runBlocking {
            `when`(service.getBreeds(page = anyInt())).thenReturn(list)
            `when`(dao.addBreeds(breeds = anyList())).thenReturn(Unit)
            `when`(dao.getAll(page = anyInt())).thenReturn(database)

            val result = breedPagingSource.load(params = PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 1,
                placeholdersEnabled = false
            ))

            assert(result is PagingSource.LoadResult.Page)
            assertEquals(database + model, (result as PagingSource.LoadResult.Page).data)
        }
    }
}