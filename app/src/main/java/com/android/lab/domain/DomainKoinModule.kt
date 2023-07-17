package com.android.lab.domain

import com.android.lab.domain.usecase.GetBeersUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        GetBeersUseCase(get())
    }
}