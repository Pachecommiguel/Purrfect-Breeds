package com.purrfectbreeds.persistence.adapter

import com.purrfectbreeds.dao.BreedDaoAdapter
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.persistence.dao.BreedDao
import com.purrfectbreeds.persistence.mapper.BreedEntityMapper
import kotlinx.coroutines.flow.transform
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedDaoAdapterImp @Inject constructor(
    private val breedDao: BreedDao,
    private val breedMapper: BreedEntityMapper
) : BreedDaoAdapter {

    override suspend fun addBreeds(breeds: List<BreedModel>) {
        breedMapper.toEntity(model = breeds).forEach { breed ->
            breedDao.getById(id = breed.id)?.let {
                breed.isFavorite = it.isFavorite
                breedDao.update(breed = breed)
            } ?: breedDao.insert(breed = breed)
        }
    }

    override suspend fun getBreeds(page: Int) = breedMapper.toModel(
        entity = breedDao.getAll(offset = page * 10)
    )

    override suspend fun getAll(page: Int) = getBreeds(page = page).filter(BreedModel::isFavorite)

    override fun getAll() = breedDao.getAll().transform {
        emit(value = breedMapper.toModel(entity = it))
    }

    override suspend fun changeFavorite(id: String) {
        breedDao.getById(id = id)?.let {
            it.isFavorite = it.isFavorite.not()
            breedDao.update(breed = it)
        }
    }

    override fun getBreed(id: String) = breedDao.get(id = id).transform {
        emit(value = breedMapper.toModel(entity = it))
    }

    override fun getFavorites() = breedDao.getFavorites().transform {
        emit(value = breedMapper.toModel(entity = it))
    }
}