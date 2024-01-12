package com.purrfectbreeds.remote.service

import com.purrfectbreeds.remote.Endpoints
import com.purrfectbreeds.remote.RetrofitClient
import com.purrfectbreeds.remote.dto.ImageDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ImageService {

    @GET(Endpoints.IMAGE)
    @Headers("x-api-key:${RetrofitClient.API_KEY}")
    suspend fun getImages(
        @Path("page") page: Int,
        @Path("has_breeds") hasBreeds: Boolean = true,
        @Path("limit") limit: Int = 25,
    ): List<ImageDto>
}