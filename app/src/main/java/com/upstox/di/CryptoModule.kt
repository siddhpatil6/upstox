package com.upstox.di


import com.upstox.interfaces.ICryptoRepository
import com.upstox.interfaces.ICryptoUseCase
import com.upstox.networking.APIClient

import com.upstox.repository.CryptoRepository
import com.upstox.usecase.CryptoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CryptoModule {
    @Provides
    fun getForthCodeCase(forthCodeRepository: CryptoRepository): ICryptoUseCase = CryptoUseCase(forthCodeRepository = forthCodeRepository)

    @Provides
    fun getForthCodeRepository(apiClient: APIClient): ICryptoRepository = CryptoRepository(apiClient)


}