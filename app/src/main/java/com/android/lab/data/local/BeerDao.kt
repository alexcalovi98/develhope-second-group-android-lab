package com.android.lab.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeerDao {

    @Query("SELECT * FROM beers")
    suspend fun getAll(): List<BeerLocal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(beers: List<BeerLocal>)
}
