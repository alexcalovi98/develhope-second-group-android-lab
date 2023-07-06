package com.android.lab.data

import android.content.Context
import androidx.room.Room
import com.android.lab.data.local.BeerDao
import com.android.lab.data.local.BeerDatabase
import com.android.lab.data.remote.PunkAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependencyInjection {

    lateinit var beerRepository: BeerRepository
    private set

    fun inject(appContext: Context) {
        NetworkManager.start(appContext)
        beerRepository = BeerRepository(
            createPunkAPI(),
            createBeerDao(appContext)
        )
    }

    private fun createPunkAPI(): PunkAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PunkAPI::class.java)
    }

    private fun createBeerDao(appContext: Context): BeerDao {
        val db = Room.databaseBuilder(
            appContext,
            BeerDatabase::class.java, "database-beer"
        ).build()

        return db.beerDao()
    }
}