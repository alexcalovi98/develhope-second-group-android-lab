package com.android.lab.ui.beers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lab.data.BeerRepository
import com.android.lab.domain.usecase.GetBeersUseCase
import kotlinx.coroutines.launch

class BeersViewModel: ViewModel() {

    private val repository = BeerRepository()

    //Live data declaration to send model to the view
    private val _beersLiveData = MutableLiveData<List<BeerItem>>()
    val beersLiveData: LiveData<List<BeerItem>> = _beersLiveData

    fun getBeers() {
        viewModelScope.launch {
            val beers = repository.getBeers(1)
            val items = beers.map { BeerItem(it.name, it.imageUrl) }
            Log.d(TAG,"$items")
            _beersLiveData.postValue(items)
        }
    }

    companion object {
        private val TAG = BeersViewModel::class.java.simpleName
    }
}