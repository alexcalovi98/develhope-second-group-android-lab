package com.android.lab.data.remote

import com.android.lab.data.local.BeerLocal
import com.android.lab.domain.models.Beer
import com.google.gson.annotations.SerializedName

data class BeerRemote(
    val id: String,
    val name: String,
    val tagline: String,
    @SerializedName("first_brewed") val firstBrewed: String,
    //private val description: String,
    @SerializedName("image_url") val imageUrl: String
)

fun BeerRemote.toBeer() = Beer(name, imageUrl)

fun List<BeerRemote>.toBeerList() = map { it.toBeer() }

fun BeerRemote.toLocal() = BeerLocal(
    name.lowercase().replace(" ", "-"),
    name, imageUrl
)

fun List<BeerRemote>.toLocalList() = map { it.toLocal() }
