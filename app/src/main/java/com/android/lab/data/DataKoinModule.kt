package com.android.lab.data

import android.content.Context
import androidx.room.Room
import com.android.lab.data.local.BeerDatabase
import com.android.lab.data.local.BeerPreferences
import com.android.lab.data.remote.PunkAPI
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BEER_PREF = "BEER_PREF"

val dataModule = module {

    single {
        BeerRepository(get(), get())
    }

    single {
        BeerPreferences(
            androidApplication().getSharedPreferences(
                BEER_PREF, Context.MODE_PRIVATE
            )
        )
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PunkAPI::class.java)
    }

    single {
        val db = Room.databaseBuilder(
            get(),
            BeerDatabase::class.java, "database-beer"
        ).build()

        db.beerDao()
    }
}