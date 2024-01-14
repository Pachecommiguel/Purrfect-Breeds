package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.MarkAsFavoriteUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarkAsFavoriteUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : MarkAsFavoriteUseCase {

    override suspend fun invoke(id: String) {
        breedRepository.markAsFavorite(id = id)
    }
}