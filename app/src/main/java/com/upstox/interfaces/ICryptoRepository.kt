package com.upstox.interfaces
import com.upstox.data.CryptoItem

interface  ICryptoRepository {
  suspend fun getListOfPhotos(): List<CryptoItem>

}