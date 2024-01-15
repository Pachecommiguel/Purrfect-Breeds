package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.GetOfflineBreedsUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetOfflineBreedsUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : GetOfflineBreedsUseCase {

    override fun invoke() = breedRepository.getAll()
}