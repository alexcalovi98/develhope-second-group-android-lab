package com.android.lab.data

import com.android.lab.domain.models.Beer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerRepository(private val punkAPI: PunkAPI) {

    suspend fun getBeers(page: Int) = punkAPI.getBeers(page)
        .map { Beer(it.name, it.tagline, it.imageUrl) }
}