package com.android.lab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BeerLocal::class], version = 1, exportSchema = false)
abstract class BeerDatabase: RoomDatabase() {
    abstract fun beerDao(): BeerDao
}