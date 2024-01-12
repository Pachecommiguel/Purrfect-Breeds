package com.purrfectbreeds.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val API_KEY = "live_k2doibU8GLYXeD4uqKpAbtxfZif2yAe8HciOTMQ5nclsiEeQ2FmcQnCsRWClQ1JL"

    private val INSTANCE: Retrofit = Retrofit.Builder()
        .baseUrl(Endpoints.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(classType: Class<T>): T = INSTANCE.create(classType)
}