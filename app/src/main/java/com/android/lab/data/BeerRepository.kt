package com.android.lab.data

import com.android.lab.data.local.BeerDao
import com.android.lab.data.local.toBeerList
import com.android.lab.data.remote.PunkAPI
import com.android.lab.data.remote.toBeerList
import com.android.lab.data.remote.toLocalList
import com.android.lab.domain.models.Beer

class BeerRepository(
    private val punkAPI: PunkAPI,
    private val beerDao: BeerDao
) {

    suspend fun getBeers(page: Int): List<Beer> {
        return if(NetworkManager.isConnected) {
            val beersRemote = punkAPI.getBeers(page)
            val beersLocal = beersRemote.toLocalList()
            beerDao.insertAll(beersLocal)
            beersRemote.toBeerList()
        } else {
            beerDao.getAll().toBeerList()
        }
    }
}