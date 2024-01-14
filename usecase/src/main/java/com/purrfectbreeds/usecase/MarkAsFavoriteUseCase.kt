package com.purrfectbreeds.usecase

interface MarkAsFavoriteUseCase {
    suspend operator fun invoke(id: String)
}