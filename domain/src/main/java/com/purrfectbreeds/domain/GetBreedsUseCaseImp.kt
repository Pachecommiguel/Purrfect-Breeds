package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.GetBreedsUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBreedsUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : GetBreedsUseCase {

    override suspend fun invoke() = breedRepository.getAll()
}