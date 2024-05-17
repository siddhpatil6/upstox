package com.upstox.usecase


import com.upstox.interfaces.ICryptoUseCase
import com.upstox.data.CryptoItem
import com.upstox.repository.CryptoRepository
import javax.inject.Inject

class CryptoUseCase @Inject constructor(private val forthCodeRepository: CryptoRepository) :
    ICryptoUseCase {
    override suspend fun getListOfPhotos(): List<CryptoItem> {
        return forthCodeRepository.getListOfPhotos()
    }

}