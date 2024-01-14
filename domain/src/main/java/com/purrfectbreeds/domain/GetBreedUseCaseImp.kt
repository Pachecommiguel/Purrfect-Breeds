package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.GetBreedUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBreedUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : GetBreedUseCase {

    override fun invoke(id: String) = breedRepository.getBreed(id = id)
}