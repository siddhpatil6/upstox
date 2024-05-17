package com.upstox.networking


import com.upstox.data.CryptoItem
import retrofit2.http.GET


interface ApiInterface {
    @GET("/photos")
    suspend fun getPhotosList(): List<CryptoItem>


}