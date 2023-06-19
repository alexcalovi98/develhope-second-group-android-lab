package com.android.lab.domain.usecase

import com.android.lab.data.BeerRepository

class GetBeersUseCase {

    private val beerRepository = BeerRepository()

    suspend operator fun invoke(page: Int) =
        beerRepository.getBeers(page)
}