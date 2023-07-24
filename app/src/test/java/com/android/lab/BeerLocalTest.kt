package com.android.lab

import com.android.lab.data.local.BeerLocal
import com.android.lab.data.local.toBeer
import org.junit.Assert.assertEquals
import org.junit.Test

class BeerLocalTest {

    @Test
    fun `test convert to domain model`() {
        //Given
        val beerLocal = BeerLocal("12", "Punk Beer IPA", "image-url")

        //When
        val beer = beerLocal.toBeer()

        //Then
        assertEquals("Punk Beer IPA", beer.name)
        assertEquals("image-url", beer.image)
    }
}