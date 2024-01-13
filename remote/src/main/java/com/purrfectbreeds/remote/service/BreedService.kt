package com.purrfectbreeds.remote.service

import com.purrfectbreeds.remote.Endpoints
import com.purrfectbreeds.remote.RetrofitClient
import com.purrfectbreeds.remote.dto.BreedDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BreedService {

    @GET(Endpoints.BREED)
    @Headers("x-api-key:${RetrofitClient.API_KEY}")
    suspend fun getBreeds(
        @Query("page") page: Int,
        @Query("order") order: String = "ASC",
        @Query("limit") limit: Int = 10,
    ): List<BreedDto>
}