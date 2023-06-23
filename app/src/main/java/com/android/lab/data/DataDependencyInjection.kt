package com.android.lab.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependencyInjection {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val punkAPI = retrofit.create(PunkAPI::class.java)

    val beerRepository = BeerRepository(punkAPI)
}