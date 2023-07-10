package com.android.lab.data.local

import android.content.SharedPreferences
import androidx.core.content.edit

class BeerPreferences(
    private val sharedPreferences: SharedPreferences
) {

    fun saveFavouriteBeer(beer: String) {
        sharedPreferences.edit {
            putString(FAVOURITE_BEER, beer)
            apply()
        }
    }

    fun getFavouriteBeer() =
        sharedPreferences
            .getString(FAVOURITE_BEER, null)

    companion object {
        private const val FAVOURITE_BEER = "FAVOURITE_BEER"
    }

}