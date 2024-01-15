package com.purrfectbreeds.test.remote

import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.remote.dto.BreedDto
import com.purrfectbreeds.remote.mapper.BreedMapperImp
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BreedMapperImpTest {

    companion object {
        private const val TEST_STRING = "test"
        private const val BLANK_STRING = " "
    }

    private val breedMapper = BreedMapperImp()

    @Test
    fun shouldReturnEmptyListWhenArgumentIsNull() {
        assertEquals(
            listOf<BreedModel>(),
            breedMapper.toModel(dto = null)
        )
    }

    @Test
    fun shouldReturnEmptyListWhenArgumentsOnlyHaveNullIds() {
        val list = listOf(
            BreedDto(),
            BreedDto()
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals(0, result.size)
    }

    @Test
    fun shouldReturnListWithNullIdsRemoved() {
        val list = listOf(
            BreedDto(),
            BreedDto(id = TEST_STRING, name = TEST_STRING)
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals(1, result.size)
    }

    @Test
    fun shouldReturnListWithBlankIdsRemoved() {
        val list = listOf(
            BreedDto(id = BLANK_STRING, name = TEST_STRING),
            BreedDto(id = TEST_STRING, name = TEST_STRING)
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals(1, result.size)
    }

    @Test
    fun shouldReturnListWithNullIdsAndNamesRemoved() {
        val list = listOf(
            BreedDto(id = BLANK_STRING, name = TEST_STRING),
            BreedDto(id = TEST_STRING, name = BLANK_STRING),
            BreedDto(id = BLANK_STRING, name = BLANK_STRING),
            BreedDto(id = TEST_STRING, name = TEST_STRING)
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals(1, result.size)
    }

    @Test
    fun shouldReturnLifespan8ForRange8_10() {
        val list = listOf(
            BreedDto(id = TEST_STRING, name = TEST_STRING, lifespan = "8-10")
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals("8", result.first().lifespan)
    }

    @Test
    fun shouldReturnLifespan10ForRange10_11() {
        val list = listOf(
            BreedDto(id = TEST_STRING, name = TEST_STRING, lifespan = "10-11")
        )

        val result = breedMapper.toModel(dto = list)
        assertEquals("10", result.first().lifespan)
    }
}