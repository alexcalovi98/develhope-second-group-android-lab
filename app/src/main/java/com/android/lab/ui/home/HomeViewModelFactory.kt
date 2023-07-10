package com.android.lab.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.lab.data.DataDependencyInjection

class HomeViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //dependency injection
        val beerPreferences = DataDependencyInjection.beerPreferences
        return HomeViewModel(beerPreferences) as T
    }
}