package com.purrfectbreeds.persistence.adapter

import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.dao.BreedDao
import com.purrfectbreeds.persistence.mapper.BreedEntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedDaoAdapterImp @Inject constructor(
    private val breedDao: BreedDao,
    private val breedMapper: BreedEntityMapper
) : BreedDaoAdapter {

    override suspend fun addBreeds(breeds: List<BreedModel>) {
        breedMapper.toEntity(model = breeds).forEach {
            breedDao.insert(breed = it)
        }
    }

    override suspend fun getBreeds(page: Int) = breedMapper.toModel(
        entity = breedDao.getAll(offset = page * 10)
    )
}