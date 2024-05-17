package com.upstox.repository

import com.upstox.networking.APIClient
import com.upstox.networking.ApiInterface
import com.upstox.interfaces.ICryptoRepository
import com.upstox.data.CryptoItem
import javax.inject.Inject

class CryptoRepository @Inject constructor (var apiClient: APIClient): ICryptoRepository {

    override suspend fun getListOfPhotos(): List<CryptoItem> {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getPhotosList()
    }


}