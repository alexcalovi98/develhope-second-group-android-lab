package com.android.lab.repository

import com.google.gson.annotations.SerializedName

data class BeerRemote(
    private val id: String,
    private val name: String,
    private val tagline: String,
    @SerializedName("first_brewed") private val firstBrewed: String,
    //private val description: String,
    @SerializedName("image_url") private val imageUrl: String
)
