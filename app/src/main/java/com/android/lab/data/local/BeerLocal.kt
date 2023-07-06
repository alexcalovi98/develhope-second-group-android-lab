package com.android.lab.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.lab.data.remote.BeerRemote
import com.android.lab.domain.models.Beer

@Entity(tableName = "beers")
data class BeerLocal(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String
)

fun BeerLocal.toBeer() = Beer(name, imageUrl)

fun List<BeerLocal>.toBeerList() = map { it.toBeer() }