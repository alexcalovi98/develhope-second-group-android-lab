package com.android.lab.ui.beers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lab.repository.PunkAPI
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeersViewModel : ViewModel() {

    private val punkAPI: PunkAPI

    private val _beersLiveData = MutableLiveData<List<BeerItem>>()
    val beersLiveData: LiveData<List<BeerItem>> = _beersLiveData

    init {
        //Retrofit Creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //API creation
        punkAPI = retrofit.create(PunkAPI::class.java)
    }

    fun getBeers() {
        viewModelScope.launch {
            val beers = punkAPI.getBeers(1)
            val items = beers.map { BeerItem(it.name, it.imageUrl) }
            Log.d(TAG,"$items")
            _beersLiveData.postValue(items)
        }
    }

    companion object {
        private val TAG = BeersViewModel::class.java.simpleName
    }
}