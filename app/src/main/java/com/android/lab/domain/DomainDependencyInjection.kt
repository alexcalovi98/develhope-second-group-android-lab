package com.android.lab.domain

import com.android.lab.data.DataDependencyInjection
import com.android.lab.domain.usecase.GetBeersUseCase

object DomainDependencyInjection {

    val getBeersUseCase = GetBeersUseCase(
        DataDependencyInjection.beerRepository
    )
}