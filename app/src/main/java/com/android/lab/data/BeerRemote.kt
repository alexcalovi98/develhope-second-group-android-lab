package com.android.lab.data

import com.google.gson.annotations.SerializedName

data class BeerRemote(
    val id: String,
    val name: String,
    val tagline: String,
    @SerializedName("first_brewed") val firstBrewed: String,
    //private val description: String,
    @SerializedName("image_url") val imageUrl: String
)
