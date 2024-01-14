package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.BreedRepository
import com.purrfectbreeds.usecase.GetFavoritesUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFavoritesUseCaseImp @Inject constructor(
    private val breedRepository: BreedRepository
) : GetFavoritesUseCase {

    override fun invoke() = breedRepository.getFavorites()
}