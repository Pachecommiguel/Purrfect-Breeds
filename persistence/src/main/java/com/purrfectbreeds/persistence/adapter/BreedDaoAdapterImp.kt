package com.purrfectbreeds.persistence.adapter

import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.dao.BreedDao
import com.purrfectbreeds.persistence.entity.BreedEntity
import com.purrfectbreeds.persistence.mapper.BreedEntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedDaoAdapterImp @Inject constructor(
    private val breedDao: BreedDao,
    private val breedMapper: BreedEntityMapper
) : BreedDaoAdapter {

    private var breeds = mutableListOf<BreedEntity>()

    override suspend fun addBreeds(breeds: List<BreedModel>) {
        breedMapper.toEntity(model = breeds).forEach {
            breedDao.insert(breed = it)
        }
    }

    override suspend fun getBreeds(page: Int): List<BreedModel> {
        val breeds = breedDao.getAll(offset = page * 10)
        this.breeds.addAll(elements = breeds)
        return breedMapper.toModel(entity = breeds)
    }

    override suspend fun getFavorites(page: Int) = getBreeds(page = page).filter(BreedModel::isFavorite)

    override suspend fun addFavorite(id: String) {
        breeds.firstOrNull { it.id == id }?.let {
            it.isFavorite = true
            breedDao.update(breed = it)
        }
    }
}