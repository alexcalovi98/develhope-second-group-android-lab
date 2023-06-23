package com.android.lab.ui.beers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.lab.domain.DomainDependencyInjection

class BeersViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //dependency injection
        val getBeersUseCase = DomainDependencyInjection.getBeersUseCase
        return BeersViewModel(getBeersUseCase) as T
    }
}