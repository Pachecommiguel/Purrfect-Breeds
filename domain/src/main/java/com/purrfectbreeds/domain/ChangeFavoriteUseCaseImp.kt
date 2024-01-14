package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.ChangeFavoriteUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChangeFavoriteUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : ChangeFavoriteUseCase {

    override suspend fun invoke(id: String) {
        breedRepository.changeFavorite(id = id)
    }
}