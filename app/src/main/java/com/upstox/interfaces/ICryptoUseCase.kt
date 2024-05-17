package com.upstox.interfaces

import com.upstox.data.CryptoItem

interface ICryptoUseCase {
    suspend fun getListOfPhotos(): List<CryptoItem>

}