package com.android.lab.ui

import com.android.lab.ui.beers.BeersViewModel
import com.android.lab.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { BeersViewModel(get()) }
}