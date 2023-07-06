package com.android.lab.data.remote

import com.android.lab.data.remote.BeerRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkAPI {

    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int): List<BeerRemote>
}