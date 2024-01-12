package com.purrfectbreeds.domain

import com.purrfectbreeds.repository.ImageRepository
import com.purrfectbreeds.usecase.GetImagesUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetImagesUseCaseImp @Inject constructor(
    private val imageRepository: ImageRepository
) : GetImagesUseCase {

    override suspend fun invoke() = imageRepository.getAll()
}