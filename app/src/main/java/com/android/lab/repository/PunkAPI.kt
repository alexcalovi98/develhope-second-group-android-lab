package com.android.lab.repository

import retrofit2.http.GET
import retrofit2.http.Query

interface PunkAPI {

    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int): List<BeerRemote>
}