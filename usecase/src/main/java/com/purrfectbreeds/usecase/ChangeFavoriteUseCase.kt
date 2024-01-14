package com.purrfectbreeds.usecase

interface ChangeFavoriteUseCase {
    suspend operator fun invoke(id: String)
}