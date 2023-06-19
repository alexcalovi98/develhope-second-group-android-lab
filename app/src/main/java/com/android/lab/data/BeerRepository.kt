package com.android.lab.data

import com.android.lab.domain.models.Beer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerRepository {

    private val punkAPI: PunkAPI

    init {
        //Retrofit Creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //API creation
        punkAPI = retrofit.create(PunkAPI::class.java)
    }

    suspend fun getBeers(page: Int) = punkAPI.getBeers(page)
        .map { Beer(it.name, it.tagline, it.imageUrl) }
}