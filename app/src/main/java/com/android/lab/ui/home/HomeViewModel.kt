package com.android.lab.ui.home

import androidx.lifecycle.ViewModel
import com.android.lab.data.local.BeerPreferences

class HomeViewModel(private val beerPreferences: BeerPreferences): ViewModel() {

    fun getFavouriteBeer() = beerPreferences.getFavouriteBeer()

    fun saveFavouriteBeer(beer: String) = beerPreferences.saveFavouriteBeer(beer)

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}