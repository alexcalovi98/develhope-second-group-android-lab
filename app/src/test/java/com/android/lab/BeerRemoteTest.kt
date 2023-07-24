package com.android.lab

import com.android.lab.data.remote.BeerRemote
import com.android.lab.data.remote.toBeer
import com.android.lab.data.remote.toLocal
import org.junit.Assert.assertEquals
import org.junit.Test

class BeerRemoteTest {

    @Test
    fun `test convert to domain model`() {
        //Given
        val beerRemote = BeerRemote("12", "Punk Beer IPA", "The best IPA of the world!", "01/2020", "image-url")

        //When
        val beer = beerRemote.toBeer()

        //Then
        assertEquals("Punk Beer IPA", beer.name)
        assertEquals("image-url", beer.image)
    }

    @Test
    fun `test convert to local model`() {
        //Given
        val beerRemote = BeerRemote("12", "Punk Beer IPA", "The best IPA of the world!", "01/2020", "image-url")

        //When
        val beerLocal = beerRemote.toLocal()

        //Then
        assertEquals("punk-beer-ipa", beerLocal.id)
        assertEquals("Punk Beer IPA", beerLocal.name)
        assertEquals("image-url", beerLocal.imageUrl)
    }
}