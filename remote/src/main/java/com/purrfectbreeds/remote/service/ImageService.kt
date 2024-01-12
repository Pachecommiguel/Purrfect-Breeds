package com.purrfectbreeds.remote.service

import com.purrfectbreeds.remote.Endpoints
import com.purrfectbreeds.remote.RetrofitClient
import com.purrfectbreeds.remote.dto.ImageDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageService {

    @GET(Endpoints.IMAGE)
    @Headers("x-api-key:${RetrofitClient.API_KEY}")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("order") order: String = "DESC",
        @Query("has_breeds") hasBreeds: Boolean = true,
        @Query("limit") limit: Int = 10,
    ): List<ImageDto>
}